package json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class FormatExample {

    public static void main(String[] args) throws Exception {
        String uglyJSONString = "{\"data1\":100,\"data2\":\"hello\",\"list\":[\"String 1\",\"String 2\",\"String 3\"]}";
        String prettyJsonString = jsonFormatter(uglyJSONString);
        System.out.println("JSON格式化前：");
        System.out.println(uglyJSONString);
        System.out.println("JSON格式化后：");
        System.out.println(prettyJsonString);
    }

    public static String jsonFormatter(String uglyJSONString) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJSONString);
        return gson.toJson(je);
    }
}
