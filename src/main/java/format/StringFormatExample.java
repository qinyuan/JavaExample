package format;

/**
 * Created by qinyuan on 14-7-14.
 */
public class StringFormatExample {

    public static void main(String[] args) throws Exception{
        String str = String.format("%sHelloWorld%s", "test", "me");
        System.out.println(str);
    }
}
