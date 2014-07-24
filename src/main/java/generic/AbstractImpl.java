package generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by qinyuan on 14-7-24.
 */
public abstract class AbstractImpl<T> implements Base<T> {
    @Override
    public T get(String id) {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        System.out.println(params.length);
        System.out.println(params[0]);
        return null;
    }
}
