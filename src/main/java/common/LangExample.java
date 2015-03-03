package common;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;
import java.util.GregorianCalendar;

import static common.PrintUtils.print;

/**
 * Example of commons-lang
 * Created by qinyuan on 15-1-30.
 */
public class LangExample {
    public static void main(String[] args) {
        /*
        print(SystemUtils.getJavaHome());
        print(SystemUtils.getJavaIoTmpDir());
        print(SystemUtils.getUserDir());
        print(SystemUtils.getUserHome());
        print(SystemUtils.JAVA_VERSION);
        */

        print(DateFormatUtils.format(new Date(), "yyyy-MM-DD"));
        print(DateFormatUtils.format(new Date().getTime(), "yyyy-MM-DD"));
        print(DateFormatUtils.format(new GregorianCalendar(), "yyyy-MM-DD"));
        print(StringUtils.leftPad(String.valueOf(5), 2, '0'));
    }
}
