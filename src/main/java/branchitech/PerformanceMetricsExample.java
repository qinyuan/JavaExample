package branchitech;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.branchitech.metrics.PerformanceMetrics;

import branchitech.metrics.MetricsBean;

public class PerformanceMetricsExample {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "bean.xml");
        MetricsBean metricsBean1, metricsBean2, metricsBean3;
        metricsBean1 = ctx.getBean("metricsBean1", MetricsBean.class);
        metricsBean2 = ctx.getBean("metricsBean2", MetricsBean.class);
        metricsBean3 = ctx.getBean("metricsBean3", MetricsBean.class);

        metricsBean1.performanceMetrics();
        metricsBean2.performanceMetrics();
        metricsBean3.performanceMetrics();

        metricsBean1.createByDefault();
        metricsBean2.createByDefault();
        metricsBean3.createByDefault();

        metricsBean1.methodByAbstractClass();
        metricsBean2.methodByAbstractClass();
        metricsBean3.methodByAbstractClass();

        metricsBean1.methodFromAbstractClass();
        metricsBean2.methodFromAbstractClass();
        metricsBean3.methodFromAbstractClass();

        metricsBean1.methodFromInterface();
        metricsBean2.methodFromInterface();
        metricsBean3.methodFromInterface();
        
        Map<String, PerformanceMetrics> metrics = PerformanceMetrics.metrics();
        System.out.println("metrics size: " + metrics.size() + "\n");
        
        for(Entry<String, PerformanceMetrics> entry:metrics.entrySet()){
            PerformanceMetrics pm=entry.getValue();
            System.out.println("getName(): "+pm.getName());
            System.out.println(pm.getCount());
            System.out.println(pm.getAllCount());
            System.out.println(pm.getMetrics().keySet());
            System.out.println();
        }
        ctx.close();
    }
}
