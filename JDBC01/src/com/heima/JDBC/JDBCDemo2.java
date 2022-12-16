package com.heima.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class JDBCDemo2 {
    public static void main(String[] args) throws Exception {
        //注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/atguigu?useSSL=false&serverTimezone=UTC";
//        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "wang9872008";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "create database db21";
        //获取执行SQL对象
        Statement stmt =conn.createStatement();
        int count= stmt.executeUpdate(sql);//执行完DML语句，受影响的行数

        System.out.println(count);

        if (count >0) {
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
        //释放资源
        stmt.close();
        conn.close();
    }
}
