package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by qinyuan on 14-8-13.
 */
public class KeySet {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("aa", "aa");
        map.put("bb", "bb");
        map.put("cc", "cc");

        Set<String> set = new HashSet(map.keySet());
        System.out.println(set);
        set.remove("aa");
        System.out.println(set);
        System.out.println(map);
    }
}
