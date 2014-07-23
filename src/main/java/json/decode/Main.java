package json.decode;

import com.fasterxml.jackson.databind.ObjectMapper;
import json.simple.FirstSub;
import json.simple.Parent;
import json.simple.SecondSub;

/**
 * Created by qinyuan on 14-7-23.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Parent first = new FirstSub();
        Parent second = new SecondSub();

        String firstJson = mapper.writeValueAsString(first);
        String secondJson = mapper.writeValueAsString(second);

        System.out.println(firstJson);
        System.out.println(secondJson);

        first = mapper.readValue(firstJson, Parent.class);
        System.out.println(first.getClass());

        second = mapper.readValue(secondJson, Parent.class);
        System.out.println(second.getClass());
    }
}
