package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qinyuan on 14-7-13.
 */
public class AopExample {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-example.xml");
        //Performer performer = ctx.getBean("performer", Performer.class);
        //performer.perform();
        Common c = (Common) ctx.getBean("common");
        c.execute("aa", "bb");
    }
}
