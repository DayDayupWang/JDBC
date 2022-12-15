package com.heima;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;


public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {
        //注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
        //useSSL=false代表不开启SSL节省性能
        String url = "jdbc:mysql://localhost:3306/atguigu?useSSL=false&serverTimezone=UTC";
//        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "wang9872008";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "";
        String sql1 = "";
        //获取执行SQL对象
        Statement stmt = conn.createStatement();

        //try catch 处理可能出现的异常
        try {
            //开启事务
            conn.setAutoCommit(false);
        //执行sql
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        }
        //释放资源
        stmt.close();
        conn.close();
    }
}
