package json.tree;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * Created by qinyuan on 14-7-30.
 */
public class TreeExample {

    public static void main(String[] args) throws Exception {
        final String path = Class.class.getResource("/").getPath();
        String json = FileUtils.readFileToString(new File(path + "tree.json"));
        ObjectMapper mapper = new ObjectMapper();
        Object obj = mapper.readValue(json, Object.class);
        System.out.println(obj);
    }
}
