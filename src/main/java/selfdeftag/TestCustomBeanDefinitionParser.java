package selfdeftag;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class TestCustomBeanDefinitionParser implements BeanDefinitionParser {

	public BeanDefinition parse(Element element, ParserContext parserContext) {
		String id = element.getAttribute("id");
		String name = element.getAttribute("name");
        String type = element.getAttribute("class");

		RootBeanDefinition beanDefinition = new RootBeanDefinition();
        if(type == null || type.equals("")) {
            beanDefinition.setBeanClass(TestBean.class);
        } else {
            try {
                beanDefinition.setBeanClass(Class.forName(type));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
		beanDefinition.getPropertyValues().addPropertyValue("name", name);
		parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);

		return beanDefinition;
	}
}
