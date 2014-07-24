package json.defaulttype;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by qinyuan on 14-7-23.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        mapper.registerSubtypes(Parent.class);
        mapper.registerSubtypes(Sub.class);

        Parent sub = new Sub("HelloWorld");
        mapper.writeValue(System.out, sub);
    }
}
