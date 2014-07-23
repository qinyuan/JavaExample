package serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinyuan on 14-7-23.
 */
public class TestSerialize {

    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("aaa", "aaaaa");
        map.put("bbb", "bbbbb");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        SerializedInterface bean = new SerializedBean(map);
        bean.setField1("field11");
        bean.setField2("field22");
        ((SerializedBean) bean).field3 = "field33";

        oos.writeObject(bean);
        System.out.println(bos);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        /*
        int ch;
        while ((ch = bis.read()) >= 0) {
            System.out.print((char) ch);
        }
        System.out.println();
        */

        ObjectInputStream ois = new ObjectInputStream(bis);
        bean = (SerializedBean) ois.readObject();

        System.out.println(bean.getField1());
        System.out.println(bean.getField2());
        System.out.println(((SerializedBean) bean).field3);
        ((SerializedBean) bean).printMap();
    }
}
