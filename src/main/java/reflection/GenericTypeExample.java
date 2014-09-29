package reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeExample<T> {

    public void printType() {
        final Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Type firstParam = params[0];
        System.out.println(firstParam);
        System.out.println(firstParam.getClass());
    }

    public static void main(String[] args) throws Exception {
        new Sub().printType();
        new SubArray().printType();
        System.out.println("test".getClass());
        System.out.println(String[].class);
        System.out.println(Class.forName("[Ljava.lang.String;"));
    }
}

class Sub extends GenericTypeExample<String> {
}

class SubArray extends GenericTypeExample<String[]> {
}
