package string;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;

/**
 * Created by qinyuan on 14-7-25.
 */
public class InputStreamToString {
    public static void main(String[] args) throws Exception {
        String str = "dfaskfjlsdjfkdsjfadka";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(str.getBytes());
        System.out.println(IOUtils.toString(inputStream));
    }
}
