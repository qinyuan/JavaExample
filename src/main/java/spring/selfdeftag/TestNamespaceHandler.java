package spring.selfdeftag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class TestNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		System.out.println("TestNamespaceHandler: init()");
		registerBeanDefinitionParser("custom", new TestCustomBeanDefinitionParser()); 
	}
}
