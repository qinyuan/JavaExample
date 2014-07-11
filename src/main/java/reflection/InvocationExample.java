package reflection;

import java.lang.reflect.Method;

/**
 * Created by qinyuan on 14-7-11.
 */
public class InvocationExample {

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        Method[] methods = Test.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("test")) {
                method.invoke(test);
            } else {
                method.invoke(null);
            }
        }
    }

    private static class Test {
        public static void testStatic() {
            System.out.println("testStatic is called");
        }

        public void test() {
            System.out.println("test is called");
        }
    }
}
