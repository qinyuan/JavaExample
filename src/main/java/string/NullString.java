package string;

/**
 * Created by qinyuan on 14-8-24.
 */
public class NullString {

    public static void main(String[] args) {
        String value = null;
        String str = new String(value);
        System.out.println(str);
    }
}
