package reflection;

import java.lang.reflect.Method;

import static common.PrintUtils.print;

public class MethodExample {

    public static void main(String[] args) throws Exception {
        Method method1 = Parent.class.getMethod("toString");
        Method method2 = Sub.class.getMethod("toString");
        Method method3 = String.class.getMethod("toString");

        print(method1.getDeclaringClass());
        print(method2.getDeclaringClass());
        print(method1.equals(method2));
        print(method1.equals(method3));
    }

    public static class Parent {
    }
    public static class Sub {
    }
}
