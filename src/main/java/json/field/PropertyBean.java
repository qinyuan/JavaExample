package json.field;

import com.fasterxml.jackson.annotation.*;

/**
 * Created by qinyuan on 14-7-23.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonIgnoreProperties({"field"})
public class PropertyBean {

    //@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    public Parent value;

    //@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    private transient Parent field;

    public void setField(Parent field) {
        this.field = field;
    }

    public Parent getField() {
        return this.field;
    }

    public PropertyBean(Parent v) {
        value = v;
    }
}
