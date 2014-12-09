package json.gson;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ParseExample {

    public static void main(String[] args) {
        String json = "{\"total\":100,,\"rows\":[{\"key\":\"key1\",\"value\":\"value1\"},{\"key\":\"key2\",\"value\":\"value2\"}]}";
        Gson gson = new Gson();
        try {
            Object map = gson.fromJson(json, Object.class);
            System.out.println(map.getClass());
        } catch(JsonSyntaxException e) {
            System.out.println(e.getMessage());
        }
    }
}
