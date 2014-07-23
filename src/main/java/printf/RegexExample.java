package printf;

/**
 * Created by qinyuan on 14-7-15.
 */
public class RegexExample {

    public static void main(String[] args) {
        //String str = "unspecifiedAppId.testGroup.HpbMGcOtGI = testValue testUnit";
        String str = "\nunspecifiedAppId.testGroup.HpbMGcOtGI = testValue testUnit\n";
        System.out.println(str.matches("\n(.*\\.)+HpbMGcOtGI\\s=\\s.*\n"));
    }
}
