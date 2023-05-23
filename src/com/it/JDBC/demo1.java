package com.it.JDBC;

import java.sql.*;

public class demo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.11.130:3306/db1", "root", "ckns818");
        Statement statement = con.createStatement();
        String sql = "select * from product";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString("name"));
        }
        con.close();
        statement.close();
        resultSet.close();
    }
}
