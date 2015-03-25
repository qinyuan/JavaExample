package branchitech.metrics;

import branchitech.metrics.bean.ExceptionBean;
import branchitech.metrics.bean.MetricsBean;
import branchitech.metrics.bean.SimpleBean;
import branchitech.report.GangliaReporterExample;
import com.codahale.metrics.MetricRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static branchitech.metrics.PerformanceMetricsUtils.printPerformanceMetrics;

public class PerformanceMetricsExample2 {

    private static void createMetricsBean(ApplicationContext ctx, String name) {
        MetricsBean bean = ctx.getBean(name, MetricsBean.class);
        bean.performanceMetrics();
        bean.createByDefault();
        bean.methodFromAbstractClass();
        bean.methodByAbstractClass();
        bean.methodFromInterface();
    }

    private static void createExceptionBean(ApplicationContext ctx, String name) {
        ExceptionBean bean = ctx.getBean(name, ExceptionBean.class);
        try {
            bean.performanceMetrics();
        } catch (Exception e) {
            //
        }
        try {
            bean.createByDefault();
        } catch (Exception e) {
            //
        }
        bean.methodFromAbstractClass();
        bean.methodByAbstractClass();
        bean.methodFromInterface();
    }

    private static void createSimpleBean(ApplicationContext ctx, String name) {
        SimpleBean bean = ctx.getBean(name, SimpleBean.class);
        for (int i = 0; i < 10; i++) {
            try {
                bean.sqlExceptionMetric();
            } catch (Exception e) {
                //
            }
            try {
                bean.ioExceptionMetric();
            } catch (Exception e) {
                //
            }
            bean.normalMetric();
        }
    }

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "perf-metrics2.xml");

        createMetricsBean(ctx, "metricsBean1");
        createMetricsBean(ctx, "metricsBean2");
        createMetricsBean(ctx, "metricsBean3");
        createExceptionBean(ctx, "exceptionBean1");
        createSimpleBean(ctx, "simpleBean1");

        MetricRegistry registry = ctx.getBean("metricRegistry", MetricRegistry.class);
        GangliaReporterExample example = new GangliaReporterExample(registry);
        example.run();

        while (true) {
            printPerformanceMetrics();
            Thread.sleep(3000);
        }
    }
}
