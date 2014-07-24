package json.constructor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by qinyuan on 14-7-24.
 */
public class Sub {

    private String str;

    @JsonCreator
    public Sub(@JsonProperty("str") String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
