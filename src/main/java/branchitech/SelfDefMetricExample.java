package branchitech;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * 本例创建一个自定义指标
 * Created by qinyuan on 10/10/14.
 */
public class SelfDefMetricExample {

    public SelfDefMetricExample getObjectValue() {
        System.out.println("========= getObjectValue invoked =========");
        return new SelfDefMetricExample();
    }

    /**
     * 这里返回一个包含800个字符的StringBuilder，如果返回的字符串包含900个以上的字符，则有可能会出现buffer overflow异常
     * @return 包含800个字符的StringBuilder
     */
    public StringBuilder getStringBuilderValue() {
        System.out.println("========= getStringBuilderValue invoked =========");
        StringBuilder builder = new StringBuilder(StringUtils.repeat("c", 800));
        return builder;
    }

    public int getIntegerValue() {
        System.out.println("========= getIntValue invoked =========");
        return 1000;
    }

    public float getFloatValue() {
        System.out.println("========= getFloatValue invoked =========");
        return new Random().nextFloat();
    }

    public String getStringValue() {
        System.out.println("========= getStringValue invoked =========");
        return "Hello World";
    }

    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("self-def-metric-example.xml");
        while (true) {
            Thread.sleep(10000);
        }
    }
}
