package json.register;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by qinyuan on 14-7-23.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
public interface Parent {

    String getName();
}
