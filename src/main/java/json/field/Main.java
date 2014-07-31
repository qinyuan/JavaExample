package json.field;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by qinyuan on 14-7-23.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Parent sub = new Sub();

        PropertyBean bean = new PropertyBean(sub);
        bean.setField(sub);
        bean.setValue2(sub);

        String json = mapper.writeValueAsString(bean);
        System.out.println(json);

        bean = mapper.readValue(json, PropertyBean.class);
        System.out.println(bean.getClass());
    }
}
