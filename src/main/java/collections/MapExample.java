package collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by qinyuan on 14-7-20.
 */
public class MapExample {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        map.put("d", "dd");

        Set<String> set = new HashSet<String>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals("bb")) {
                set.add(entry.getKey());
            }
        }
        for (String str : set) {
            map.remove(str);
        }
        System.out.println(map);
    }
}
