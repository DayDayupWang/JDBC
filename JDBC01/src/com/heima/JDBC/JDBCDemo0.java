package com.heima.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class JDBCDemo0 {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/atguigu?useSSL=false&serverTimezone=UTC";
//        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "wang9872008";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "";
        //获取执行SQL对象
        Statement stmt =conn.createStatement();
        int count= stmt.executeUpdate(sql);
        //释放资源
        stmt.close();
        conn.close();
    }
}
