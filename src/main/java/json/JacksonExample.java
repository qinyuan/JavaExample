package json;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qinyuan on 14-7-22.
 */
public class JacksonExample {

    private ObjectMapper objectMapper;
    private JsonGenerator generator;

    JacksonExample() {
        try {
            objectMapper = new ObjectMapper();
            generator = objectMapper.getFactory().createGenerator(System.out, JsonEncoding.UTF8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void beanToJson() throws Exception {
        TestJsonBean test = new TestJsonBean();
        test.setTest("HelloWorld");
        generator.writeObject(test);
    }

    void mapToJson() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        generator.writeObject(map);
    }

    void listToJson() throws Exception {
        List<TestJsonBean> list = new ArrayList<TestJsonBean>();

        TestJsonBean bean = new TestJsonBean();
        bean.setTest("HelloWorld1");
        list.add(bean);

        bean = new TestJsonBean();
        bean.setTest("HelloWorld2");
        list.add(bean);

        generator.writeObject(list);
    }

    void jsonToBean() throws Exception {
        String json = "{\"test\":\"HelloWorld Again and again\"}";
        TestJsonBean bean = objectMapper.readValue(json, TestJsonBean.class);
        System.out.println("getTest: " + bean.getTest());
    }

    private static void printline() {
        System.out.println("\n======================");
    }

    public static void main(String[] args) throws Exception {
        JacksonExample example = new JacksonExample();
        example.beanToJson();
        printline();

        example.mapToJson();
        printline();

        example.listToJson();
        printline();

        example.jsonToBean();
    }
}
