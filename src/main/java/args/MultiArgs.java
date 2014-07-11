package args;

import java.util.Random;

/**
 * Created by qinyuan on 14-7-8.
 */
public class MultiArgs {

    private static void test(String... strs) {
        for (String str : strs) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        test("a", "b", "c");
        String[] strs = {"1", "2", "3"};
        test(strs);
    }
}
