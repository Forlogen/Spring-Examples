package dyliang.utils;

import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection(){
        try{
            Connection conn = tl.get();
            if (conn == null){
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            return conn;
        } catch (Throwable t){
            throw new RuntimeException(t);
        }
    }

    public void removeConnection(){
        tl.remove();
    }
}
