package json.register;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;

public class Main {

    static void print(String str) {
        System.out.println(str);
    }

    static void write() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerSubtypes(new NamedType(Sub.class, "sub"));
        Parent sub = new Sub("HelloWorld");
        print(mapper.writeValueAsString(sub));

        mapper.registerSubtypes(new NamedType(Sub2.class, "sub2"));
        Parent sub2 = new Sub2("HelloWorld");
        print(mapper.writeValueAsString(sub2));
    }

    static void read() throws Exception {
        String subJson = "{\"@type\":\"sub\",\"name\":\"HelloWorld\"}";
        String sub2Json = "{\"@type\":\"sub2\",\"name\":\"HelloWorld\"}";

        ObjectMapper mapper = new ObjectMapper();

        // 所有register操作必须在所有readValue操作之前，否则会无效
        mapper.registerSubtypes(new NamedType(Sub.class, "sub"));
        mapper.registerSubtypes(new NamedType(Sub2.class, "sub2"));

        mapper.readValue(subJson, Parent.class);
        mapper.readValue(sub2Json, Parent.class);
    }

    public static void main(String[] args) throws Exception {
        write();
        read();
    }
}
