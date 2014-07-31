package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qinyuan on 14-7-29.
 */
public class PatternExmaple {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w\\d");
        String str = "a5, a4 and a3 papper";
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
