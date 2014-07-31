package json.constructor;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by qinyuan on 14-7-24.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Sub sub = new Sub("HelloWorld");

        String json = mapper.writeValueAsString(sub);
        System.out.println(json);

        sub = mapper.readValue(json, Sub.class);
        System.out.println(sub.getClass());

        NoField noField = new NoField();
        mapper.writeValue(System.out, noField);
    }
}
