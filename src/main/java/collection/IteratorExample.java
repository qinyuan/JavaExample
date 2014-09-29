package collection;

import java.util.Iterator;

public class IteratorExample {

    static boolean isIterator(Object obj) {
        return obj instanceof Iterator;
    }

    static void printArray(Object object) {
        if (object.getClass().isArray()) {
            Object[] objects = (Object[]) object;
            for (Object obj : objects) {
                System.out.println(obj);
            }
        }
    }

    public static void main(String[] args) {
        String[] strs = {"a", "b", "c"};
        System.out.println(isIterator(strs));
        printArray(strs);
    }
}
