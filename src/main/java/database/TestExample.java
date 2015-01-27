package database;

import com.ibatis.sqlmap.client.SqlMapClient;

import java.util.List;

/**
 * Created by qinyuan on 15-1-27.
 */
public class TestExample {

    public static void main(String[] args) throws Exception {

        SqlMapClient client = IBatisUtils.getSqlMap();

        //Test test = (Test) client.queryForObject("getTest", 1);
        List results= client.queryForList("getAll");
        Test test = (Test) results.get(0);

        System.out.println(test.getTestId());
        System.out.println(test.getTestName());
        System.out.println(test.getTestXml());
        System.out.println(test.getTestXml().length());
    }
}
