package json.field;

import com.fasterxml.jackson.annotation.*;

/**
 * Created by qinyuan on 14-7-23.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonIgnoreProperties({"field"})
public class PropertyBean {

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    public Parent value;

    private Parent value2;

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    private Parent field;

    public void setField(Parent field) {
        this.field = field;
    }

    public Parent getField() {
        return this.field;
    }

    public void setValue2(Parent value2) {
        this.value2 = value2;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    public Parent getValue2() {
        return value2;
    }

    @JsonCreator
    public PropertyBean(@JsonProperty("value") Parent v) {
        value = v;
    }
}
