package string;

import java.text.DecimalFormat;

/**
 * Created by qinyuan on 14-7-15.
 */
public class DecimalFormatExample {

    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat(",###,###.0000");
        System.out.println(format.format(111111111.11111111111));

        format = new DecimalFormat(",###,###.0000");
        System.out.println(format.format(1.11111111111));
    }
}
