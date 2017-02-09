package sqlite;

import novemberizing.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 9.
 */
public class DB {
    private static final String Tag = "sqlite/db>";
    private String __url = null;
    private Connection __connection = null;

    public boolean open(){
        if(__connection==null){
            try {
                __connection = DriverManager.getConnection(__url);
            } catch (SQLException e){
                Log.e(Tag, e.getMessage());
            }
        }
        return __connection!=null;
    }

    public void close(){
        if(__connection!=null){
            try {
                __connection.close();
            } catch (SQLException e) {
                Log.e(Tag, e.getMessage());
            } finally {
                __connection = null;
            }
        }
    }
}
