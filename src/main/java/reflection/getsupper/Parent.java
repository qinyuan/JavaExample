package reflection.getsupper;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class Parent<T> implements IParent<T> {

    public void test() {
        ParameterizedType genType = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] arguments = genType.getActualTypeArguments();
        Type argument = arguments[0];
        if (argument instanceof GenericArrayType) {
            System.out.println("==========");
            GenericArrayType arrayType = (GenericArrayType) argument;
            System.out.println(arrayType.getClass());
            System.out.println(arrayType.toString());
            argument = arrayType.getGenericComponentType();
        }

        System.out.print(argument.getClass());
        System.out.print(" ");
        System.out.println(argument);
    }
}
