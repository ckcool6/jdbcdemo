package SQLpool;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.JDBC4Connection;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class MyConnectionT extends JDBC4Connection {
    private Connection con;
    private List<Connection> pool;

    public MyConnectionT(String hostToConnectTo, int portToConnectTo, Properties info, String databaseToConnectTo, String url, Connection con, List<Connection> pool) throws SQLException {
        super(hostToConnectTo, portToConnectTo, info, databaseToConnectTo, url);
        this.con = con;
        this.pool = pool;
    }

    @Override
    public void close() throws SQLException {
        pool.add(con);
    }
}
