package SQLpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDataSourceTest {
    public static void main(String[] args) throws SQLException {
        MyDataSource dataSource = new MyDataSource();
        System.out.println("使用之前的数量:"+dataSource.getSize());
        Connection con = dataSource.getConnection();
        System.out.println(con.getClass());

        //
        String sql = "select * from student";
        PreparedStatement pst = con.prepareStatement(sql);

        //
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt("sid") + "\t" + rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getDate("birthday"));
        }
        rs.close();
        pst.close();
        con.close(); //用完之后关闭连接
        System.out.println("使用之后的数量:"+dataSource.getSize());
    }
}
