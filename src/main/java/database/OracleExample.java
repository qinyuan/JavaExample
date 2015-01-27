package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by qinyuan on 15-1-26.
 */
public class OracleExample {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "qinyuan";
        String password = "qinyuan";
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("create connection");

        Statement statement = conn.createStatement();
        System.out.println("create statement");

        String query = "SELECT extract(test_xml, '//names').getClobVal() from qinyuan_test";
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("create result set");

        while (resultSet.next()) {
            String field1 = resultSet.getString(1);
            System.out.println(field1);
            System.out.println(field1.length());
            //System.out.println(resultSet.getString(2));
        }

        resultSet.close();
        statement.close();
        conn.close();
    }
}
