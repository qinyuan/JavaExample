package json.decode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import json.simple.FirstSub;
import json.simple.Parent;
import json.simple.SecondSub;

public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerSubtypes(new NamedType(FirstSub.class, "firstSub"));
        mapper.registerSubtypes(new NamedType(SecondSub.class, "secondSub"));

        Parent first, second;

        String firstJson = "{\"@type\":\"firstSub\",\"name\":\"firstSub\"}";
        String secondJson = "{\"@type\":\"secondSub\",\"name\":\"secondSub\"}";

        System.out.println(firstJson);
        System.out.println(secondJson);

        first = mapper.readValue(firstJson, Parent.class);
        System.out.println(first.getClass());

        second = mapper.readValue(secondJson, Parent.class);
        System.out.println(second.getClass());

        Object obj = mapper.readValue(secondJson, Object.class);
        System.out.println(obj.getClass());
    }
}
