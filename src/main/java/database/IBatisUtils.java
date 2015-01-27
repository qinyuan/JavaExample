package database;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.Reader;

public class IBatisUtils {

    private static volatile SqlMapClient sqlMap;

    public static SqlMapClient getSqlMap() {
        if (sqlMap == null) {
            synchronized (IBatisUtils.class) {
                if (sqlMap == null) {
                    try {
                        String resource = "sqlMapConfig.xml";
                        Reader reader = Resources.getResourceAsReader(resource);
                        sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sqlMap;
    }
}
