package json.field;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by qinyuan on 14-7-23.
 */
public class PropertyBean {

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    public Parent value;

    public PropertyBean(Parent v) {
        value = v;
    }
}
