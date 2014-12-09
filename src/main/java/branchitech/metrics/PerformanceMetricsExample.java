package branchitech.metrics;

import branchitech.metrics.bean.SimpleBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static branchitech.metrics.PerformanceMetricsUtils.printPerformanceMetrics;

public class PerformanceMetricsExample {

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
                "perf-metrics.xml");
        createSimpleBean(ctx, "simpleBean1");
        while (true) {
            printPerformanceMetrics();
            Thread.sleep(3000);
        }
    }
}
