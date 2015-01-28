package database;

import com.ibatis.sqlmap.client.SqlMapClient;
import oracle.sql.CLOB;
import org.apache.commons.io.IOUtils;

import java.util.List;

public class TestExample {

    public static void main(String[] args) throws Exception {

        SqlMapClient client = IBatisUtils.getSqlMap();

        //Test test = (Test) client.queryForObject("getTest", 1);
        List results= client.queryForList("getAll");
        Test test = (Test) results.get(0);

        System.out.println(test.getTestId());
        System.out.println(test.getTestName());
        CLOB testXml = (CLOB)test.getTestXml();
        String clobString = IOUtils.toString(testXml.getCharacterStream());
        System.out.println(clobString.length());

        //System.out.println(test.getTestXml().length());
    }
}