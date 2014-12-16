package branchitech.report;

import branchitech.metrics.bean.ExceptionBean;
import com.branchitech.metrics.ganglia.GMetricBuilder;
import com.branchitech.metrics.ganglia.GangliaReporter;
import com.branchitech.metrics.ganglia.IGMetric;
import com.codahale.metrics.MetricRegistry;
import info.ganglia.gmetric4j.gmetric.GMetric;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class GangliaReporterExample2 {

    private static IGMetric getIGMetric() throws IOException {
        final String host = "239.2.11.71";
        final int port = 8649;
        final int ttl = 1;
        GMetric gMetric = new GMetric(host, port, GMetric.UDPAddressingMode.MULTICAST, ttl);
        return GMetricBuilder.build(gMetric);
    }

    private static GangliaReporter getReporter(MetricRegistry registry) throws IOException {
        GangliaReporter.Builder builder = new GangliaReporter.Builder();
        builder.to(getIGMetric());
        builder.withAppId("exampleAppId");
        builder.inRegistry(registry);
        return builder.build();
    }

    private static void execExceptionBean(ExceptionBean bean) {
        try {
            bean.performanceMetrics();
        } catch (Exception e) {
            // nothing to do
        }
    }

    private static void reportInBackground(final GangliaReporter reporter) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    reporter.report(); // report every 15 seconds
                    try {
                        Thread.sleep(15000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "perf-metrics2.xml");
        ExceptionBean bean = ctx.getBean("exceptionBean1", ExceptionBean.class);
        MetricRegistry registry = ctx.getBean("metricRegistry", MetricRegistry.class);
        GangliaReporter reporter = getReporter(registry);
        reportInBackground(reporter);

        bean.methodFromAbstractClass();
        bean.methodFromAbstractClass();
        bean.methodFromAbstractClass();
        bean.methodFromAbstractClass();
        bean.methodFromAbstractClass();
        bean.blockMethod();
    }
}
