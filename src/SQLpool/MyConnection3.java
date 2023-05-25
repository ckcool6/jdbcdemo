package SQLpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MyConnection3 extends MyAdapter{
    private Connection con;
    private List<Connection> pool;

    public MyConnection3(Connection con, List<Connection> pool) {
        super(con);
        this.con = con;
        this.pool = pool;
    }

    @Override
    public void close() throws SQLException {
        pool.add(con);
    }
}
