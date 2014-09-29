package json.array;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import json.simple.FirstSub;
import json.simple.Parent;

public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Parent firstSub = new FirstSub();
        Parent[] subs = new Parent[]{firstSub};
        String json = objectMapper.writeValueAsString(subs);

        objectMapper.registerSubtypes(new NamedType(FirstSub.class, "FirstSub"));
        objectMapper.readValue(json, Parent[].class);
    }
}
