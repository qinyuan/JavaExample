package printf;

import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by qinyuan on 14-7-11.
 */
public class RandomStringExample {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(RandomStringUtils.randomAlphabetic(10));
        }
    }
}
