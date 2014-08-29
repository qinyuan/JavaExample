package json.simple;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
public class SecondSub implements Parent {
    @Override
    public String getName() {
        return "secondSub";
    }

    public void setName(String name) {
    }
}
