package selfdeftag;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    private static void printBean(ITestBean bean, String title) {
        System.out.println(title + ":");
        System.out.print(bean.getClass() + " ");
        System.out.print("getId(): " + bean.getId() + " ");
        System.out.print("getName(): " + bean.getName() + " ");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "test.xml");
        ITestBean test = context.getBean("test1", ITestBean.class);
        printBean(test, "test1");

        test = context.getBean("test2", ITestBean.class);
        printBean(test, "test2");

        test = context.getBean("test3", ITestBean.class);
        printBean(test, "test3");

        context.close();
    }
}
