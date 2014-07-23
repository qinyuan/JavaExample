package serialize;

import java.io.Serializable;
import java.util.Map;

public class SerializedBean implements Serializable, SerializedInterface {

    private String field1;
    private String field2;
    String field3;
    private Map<String, String> map;

    public SerializedBean(Map<String, String> map) {
        this.map = map;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public void printMap() {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
