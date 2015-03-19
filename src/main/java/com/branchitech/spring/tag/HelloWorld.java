package com.branchitech.spring.tag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
    private int serial;
    private String name;

    public int getSerial() {
        return serial;
    }

    public String getName() {
        return name;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("helloWorld.xml");
        HelloWorld bean = context.getBean("testBean", HelloWorld.class);
        System.out.println(bean.getSerial());
        System.out.println(bean.getName());
    }
}
