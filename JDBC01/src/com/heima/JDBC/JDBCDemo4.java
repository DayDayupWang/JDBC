package com.heima.JDBC;

import com.heima.pojo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JDBCDemo4 {
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
        List<Account> list = new ArrayList<>();
        while (rs.next()) {
            Account account = new Account();
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double money = rs.getDouble(3);
            //给账户对象赋值
            account.setId(id);
            account.setName(name);
            account.setMoney(money);
            //放入集合
            list.add(account);
        }
        System.out.println(list);
        //释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
