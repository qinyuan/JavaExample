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
        final String host = "239.2.11.72";
        final int port = 8649;
        final int ttl = 1;
        GMetric gMetric = new GMetric(host, port, GMetric.UDPAddressingMode.MULTICAST, ttl);
        return GMetricBuilder.build(gMetric);
    }

    //private final static TimeMeter timeMeter = new TimeMeter();

    private static MetricRegistry getRegistry(ApplicationContext ctx) {
        return ctx.getBean("metricRegistry", MetricRegistry.class);
        /*
        MetricRegistry registry = new MetricRegistry();
        registry.register("testTimeMeter", timeMeter);
        return registry;
        */
    }

    private static GangliaReporter getReporter(MetricRegistry registry) throws IOException {
        GangliaReporter.Builder builder = new GangliaReporter.Builder();
        builder.to(getIGMetric());
        builder.withAppId("exampleAppId");
        builder.inRegistry(registry);
        return builder.build();
    }

    private static ExceptionBean createExceptionBean(ApplicationContext ctx) {
        return ctx.getBean("exceptionBean1", ExceptionBean.class);
    }

    private static void execExceptionBean(ExceptionBean bean) {
        try {
            bean.performanceMetrics();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "bean.xml");
        ExceptionBean bean = createExceptionBean(ctx);
        MetricRegistry registry = getRegistry(ctx);
        GangliaReporter reporter = getReporter(registry);

        int i = 0;
        while (true) {
            if (++i == 6) {
                try {
                    bean.performanceMetrics();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                i = 0;
            }
            reporter.report();
            //Thread.sleep(1000 * 60 * 2);
            Thread.sleep(1000);
        }
    }
}
