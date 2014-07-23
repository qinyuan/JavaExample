package json.simple;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by qinyuan on 14-7-23.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Parent first = new FirstSub();
        Parent second = new SecondSub();

        System.out.println(mapper.writeValueAsString(first));
        System.out.println(mapper.writeValueAsString(second));
    }
}
