package branchitech;

import branchitech.metrics.ExceptionBean;
import branchitech.metrics.MetricsBean;
import branchitech.metrics.SimpleBean;
import com.branchitech.metrics.PerformanceMetrics;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Metric;
import com.codahale.metrics.TimeMeter;
import com.codahale.metrics.Timer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Map.Entry;

public class PerformanceMetricsExample {

    private static void print(Object obj) {
        System.out.print(obj.toString());
    }

    private static void println(Object obj) {
        System.out.println(obj.toString());
    }

    private static void printMetric(Metric value) {
        if (value instanceof Counter) {
            Counter counter = (Counter) value;
            println(" getCount():" + counter.getCount());
        } else if (value instanceof TimeMeter) {
            TimeMeter timeMeter = (TimeMeter) value;
            print(" getLastMarkTimestamp():" + timeMeter.getLastTimestamp() + ";");
            print(" getMeanRate():" + timeMeter.getMeanRate() + ";");
            println(" getCount():" + timeMeter.getCount());
        } else if (value instanceof Timer) {
            Timer timer = (Timer) value;
            print(" getMeanRate():" + timer.getMeanRate() + ";");
            println(" getCount():" + timer.getCount());
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
            println("metric detail: ");

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
                "bean.xml");

        createMetricsBean(ctx, "metricsBean1");
        createMetricsBean(ctx, "metricsBean2");
        createMetricsBean(ctx, "metricsBean3");
        createExceptionBean(ctx, "exceptionBean1");
        createSimpleBean(ctx, "simpleBean1");

        /*
        MetricRegistry registry = ctx.getBean("metricRegistry", MetricRegistry.class);
        GangliaReporterExample example = new GangliaReporterExample(registry);
        example.run();
        */

        printPerformanceMetrics();
        ctx.close();
    }
}
