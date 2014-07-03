package branchitech;

import java.util.Map;
import java.util.Map.Entry;

import branchitech.metrics.ExceptionBean;
import branchitech.metrics.SimpleBean;
import com.codahale.metrics.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.branchitech.metrics.PerformanceMetrics;

import branchitech.metrics.MetricsBean;

public class PerformanceMetricsExample {

    private static void print(Object obj) {
        System.out.print(obj.toString());
    }

    private static void println(Object obj) {
        System.out.println(obj.toString());
    }

    private static void printMetric(Metric value) {
        if (value instanceof Counter) {
            println(((Counter) value).getCount());
        } else if (value instanceof TimeMeter) {
            print((System.currentTimeMillis() - ((TimeMeter) value).getLastMarkTimestamp()) + " ");
            print(((TimeMeter) value).getMeanRate() + " ");
            println(((TimeMeter) value).getCount());
        } else if (value instanceof Timer) {
            print(((Timer) value).getMeanRate() + " ");
            println(((Timer) value).getCount());
        } else {
            println(value);
        }
    }

    public static void printPerformanceMetrics() {
        Map<String, PerformanceMetrics> metrics = PerformanceMetrics.metrics();
        System.out.println("metrics size: " + metrics.size() + "\n");

        for (Entry<String, PerformanceMetrics> entry : metrics.entrySet()) {
            PerformanceMetrics pm = entry.getValue();
            println("name: " + pm.getName());
            println("count: " + pm.getCount());
            println("allCount: " + pm.getAllCount());

            for (Entry<String, Metric> metryEntry : pm.getMetrics().entrySet()) {
                print(metryEntry.getKey() + " ");
                printMetric(metryEntry.getValue());
            }

            println("");
        }
    }

    private static void createMetricsBean(ApplicationContext ctx, String name) {
        MetricsBean bean = ctx.getBean(name, MetricsBean.class);
        bean.performanceMetrics();
        bean.createByDefault();
        bean.methodFromAbstractClass();
        bean.methodByAbstractClass();
        bean.methodFromInterface();
    }

    private static void createExceptionBean(ApplicationContext ctx, String name) {
        try {
            ExceptionBean bean = ctx.getBean(name, ExceptionBean.class);
            bean.performanceMetrics();
            bean.createByDefault();
            bean.methodFromAbstractClass();
            bean.methodByAbstractClass();
            bean.methodFromInterface();
        } catch (Exception e) {
            println("Exception thrown");
        }
    }

    private static void createSimpleBean(ApplicationContext ctx, String name) {
        SimpleBean bean = ctx.getBean(name, SimpleBean.class);
        for (int i = 0; i < 10; i++) {
            try {
                bean.sqlExceptionMetric();
            } catch (Exception e) {
                println("SQLException thrown");
            }
            try {
                bean.ioExceptionMetric();
            } catch (Exception e) {
                println("IOException thrown");
            }
            bean.normalMetric();
        }
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "bean.xml");

        /*
        createMetricsBean(ctx, "metricsBean1");
        createMetricsBean(ctx, "metricsBean2");
        createMetricsBean(ctx, "metricsBean3");
        createExceptionBean(ctx, "exceptionBean1");
        */
        createSimpleBean(ctx, "simpleBean1");

        printPerformanceMetrics();
        ctx.close();
    }
}
