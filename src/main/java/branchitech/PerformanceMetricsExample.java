package branchitech;

import java.util.Map;
import java.util.Map.Entry;

import branchitech.metrics.ExceptionBean;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.Metric;
import com.codahale.metrics.Timer;
import javafx.application.Application;
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
        } else if (value instanceof Meter) {
            print(((Meter) value).getMeanRate() + " ");
            println(((Meter) value).getCount());
        } else if (value instanceof Timer) {
            print(((Timer) value).getCount() + " ");
            println(((Timer) value).getMeanRate());
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
        ExceptionBean bean = ctx.getBean(name, ExceptionBean.class);
        bean.performanceMetrics();
        bean.createByDefault();
        bean.methodFromAbstractClass();
        bean.methodByAbstractClass();
        bean.methodFromInterface();
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "bean.xml");

        createMetricsBean(ctx, "metricsBean1");
        createMetricsBean(ctx, "metricsBean2");
        createMetricsBean(ctx, "metricsBean3");
        //createExceptionBean(ctx, "exceptionBean1");

        printPerformanceMetrics();
        ctx.close();
    }
}
