package collection;

import java.util.*;

/**
 * Created by qinyuan on 14-7-31.
 */
public class SetSort {

    private static void print(Set<?> set) {
        for (Object object : set) {
            System.out.print(object + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("ccc");
        set.add("aaa");
        set.add("eee");
        set.add("bbb");
        print(set);

        TreeSet<String> treeSet = new TreeSet<String>(set);
        print(treeSet);
    }
}
