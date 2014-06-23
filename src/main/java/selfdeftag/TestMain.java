package selfdeftag;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"test.xml");
		TestBean test = context.getBean("testCustom", TestBean.class);
		System.out.println("test.getId(): " + test.getId());
		System.out.println("test.getName(): " + test.getName());
		context.close();
	}
}
