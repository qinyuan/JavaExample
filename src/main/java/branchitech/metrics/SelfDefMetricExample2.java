package branchitech.metrics;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * 这里是手工创建自定义指标的一个例子
 * Created by qinyuan on 9/28/14.
 */
public class SelfDefMetricExample2 {

    private static Random rand = new Random();

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "self-def-metric-example2.xml");

        // 这里创建了一个自定义的指标，该指标永远返回字符串HelloWorld
        Gauge<String> strGauge = new Gauge<String>() {
            @Override
            public String getValue() {
                return "HelloWorld";
            }
        };

        // 这里创建了一个自定义的指标，该指标返回随机数
        Gauge<Integer> intGauge = new Gauge<Integer>() {
            @Override
            public Integer getValue() {
                return rand.nextInt();
            }
        };


        /*
         * 获取指标注册库bean，这里的beanId对应的于spring配置文件中metrics:registry元素的id。
         * 在本例的self-def-metrics-example2.xml这个配置文件中，有这么一行配置：
         * <metrics:registry id="metricRegistry"/>。
         * 所以这里将"metricRegistry"作为getBean方法的第一个参数
         */
        MetricRegistry registry = ctx.getBean("metricRegistry", MetricRegistry.class);

        // 将自定义的gauge作为指标，加入到指标库中
        registry.register("testStringGauge", strGauge);
        registry.register("testIntgerGauge", intGauge);

        while (true) {
            /*
             * 这里使程序一直运行，程序运行之后，将会在ganglia的汇报指标中看到testStringGauge，其值一直是HelloWorld字符串。
             * 在ganglia的汇报指标中还可以看到testIntegerGauge，该指标的值不停地变化。
             * 另外需要注意的是，本程序运行之后gmond中的指标不会马上有变化，需要等待十几秒甚至几十秒
             */
            Thread.sleep(10000);
        }
    }
}
