package selfdeftag;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"test.xml");
		TestBean test = context.getBean("test1", TestBean.class);
		System.out.println("test.getId(): " + test.getId());
		System.out.println("test.getName(): " + test.getName());
		
		test = context.getBean("test2", TestBean.class);
		System.out.println("test.getId(): " + test.getId());
		System.out.println("test.getName(): " + test.getName());
		
		System.out.println(context.getBean("test3"));
		context.close();
	}
}
