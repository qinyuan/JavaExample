package json.field;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by qinyuan on 14-7-23.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Parent sub = new Sub();
        mapper.registerSubtypes(PropertyBean.class);
        System.out.println(mapper.writeValueAsString(new PropertyBean(sub)));
    }
}
