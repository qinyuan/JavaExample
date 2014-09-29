package reflection.getsupper;

import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

public class Test<T> extends ClassA<T> {

    public static void main(String args[]) throws Exception {
        /*
        System.out.println("======getSuperclass======:");
        System.out.println(Test.class.getSuperclass().getName());
        System.out.println("======getGenericSuperclass======:");
        */

        Type t = Test.class.getGenericSuperclass();
        System.out.println(t);
        if (ParameterizedType.class.isAssignableFrom(t.getClass())) {
            System.out.print("----------->getActualTypeArguments:");
            for (Type t1 : ((ParameterizedType) t).getActualTypeArguments()) {
                System.out.print(t1 + ",");
            }
            System.out.println();
        }
    }
}
