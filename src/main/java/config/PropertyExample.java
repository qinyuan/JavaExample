package config;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by qinyuan on 14-9-18.
 */
public class PropertyExample {

    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        String filePath = "src/main/resources/test.properties";
        properties.load(new FileInputStream(filePath));
        Enumeration<Object> keys = properties.keys();
        while(keys.hasMoreElements()) {
            System.out.println(keys.nextElement());
        }
    }
}
