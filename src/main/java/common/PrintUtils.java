package common;

public class PrintUtils {
    private PrintUtils() {
    }

    public static void print(Object... objs) {
        StringBuilder s = new StringBuilder();
        for (Object obj : objs) {
            s.append(obj.toString());
        }
        System.out.println(s);
    }
}
