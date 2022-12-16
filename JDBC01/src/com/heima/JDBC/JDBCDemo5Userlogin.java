package com.heima.JDBC;


import java.sql.*;


public class JDBCDemo5Userlogin {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db?useSSL=false&serverTimezone=UTC";
//        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "wang9872008";
        Connection conn = DriverManager.getConnection(url, username, password);
        String name = "zhangsan";
        String pwd = "123";
//        String sql = "SELECT * from tb_user where username='" + name + "' and password='" + pwd + "'";
        String sql = "SELECT * FROM tb_user WHERE username = ? AND password = ? ";//用？占位符替代
        //获取stmt对象
//        Statement stmt = conn.createStatement();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置？的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);

        //执行sql
        ResultSet rs = pstmt.executeQuery();//不传参
//        ResultSet rs = stmt.executeQuery(sql);
//判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        //释放资源
        rs.close();
//        stmt.close();
        pstmt.close();
        conn.close();
    }
}
