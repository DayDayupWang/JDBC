package com.heima.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCDemo3 {
    public static void main(String[] args) throws Exception {
        //注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/atguigu?useSSL=false&serverTimezone=UTC";
//        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "wang9872008";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "select * from account";
        //获取执行SQL对象
        Statement stmt = conn.createStatement();
//        int count = stmt.executeUpdate(sql);//执行完DML语句，受影响的行数
        ResultSet rs = stmt.executeQuery(sql);
//        System.out.println(count);
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double money = rs.getDouble(3);
        }
//        System.out.println(id);
//        System.out.println(name);
        //释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
