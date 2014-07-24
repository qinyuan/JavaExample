package json.register;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;

/**
 * Created by qinyuan on 14-7-23.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.registerSubtypes(Parent.class);
        //mapper.registerSubtypes(Sub.class);
        mapper.registerSubtypes(new NamedType(Parent.class, "parent"));
        mapper.registerSubtypes(new NamedType(Sub.class, "sub"));

        Parent sub = new Sub("HelloWorld");
        mapper.writeValue(System.out, sub);
    }
}
