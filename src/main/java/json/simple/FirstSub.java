package json.simple;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
final public class FirstSub implements Parent {
    @Override
    public String getName() {
        return "firstSub";
    }

    public void setName(String name) {
    }
}
