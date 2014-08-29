package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern example
 * Created by qinyuan on 14-7-29.
 */
public class PatternExmaple {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher("Hello.World Me.Too");
        System.out.println(matcher.replaceAll(""));
    }
}
