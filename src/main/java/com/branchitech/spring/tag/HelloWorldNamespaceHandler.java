package com.branchitech.spring.tag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class HelloWorldNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("custom", new HelloWorldBeanDefinitionParser());
    }
}
