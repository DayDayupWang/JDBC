package com.heima.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.heima.pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.Test;

public class BrandTest {
    //    public static void main(String[] args) throws Exception {
////        testSelectAll();
//        testAdd();
//    }
    @Test
    public void testSelectAll() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\shinelon\\Desktop\\学习过程文件\\JDBC\\JDBC01\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();
        String sql = "select * from tb_brand";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        Brand brand = null;
        ArrayList<Brand> brands = new ArrayList<>();
        //封装为BRAND对象
        while (rs.next()) {
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);
            brands.add(brand);
        }

        System.out.println(brands);
        //释放资源
        rs.close();
        pstmt.close();
        connection.close();
    }

    /**
     * 添加
     * 1. SQL：insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?);
     * 2. 参数：需要，除了id之外的所有参数信息
     * 3. 结果：boolean
     */
    @Test
    public void testAdd() throws Exception {
        //接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;

        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\shinelon\\Desktop\\学习过程文件\\JDBC\\JDBC01\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();
        //定义sql
        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?);";
        //获取pstmt对象
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //设置参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);

//执行sql DML
        int count = pstmt.executeUpdate();//影响的行数
//处理结果
        System.out.println(count > 0);
        //释放资源

        pstmt.close();
        connection.close();
    }

    /**
     * 修改
     * 1. SQL：
     * <p>
     * update tb_brand
     * set brand_name  = ?,
     * company_name= ?,
     * ordered     = ?,
     * description = ?,
     * status      = ?
     * where id = ?
     * <p>
     * <p>
     * <p>
     * 2. 参数：需要，所有数据
     * 3. 结果：boolean
     */
    @Test
    public void testUpdate() throws Exception {
        //接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1000;//修改的部分
        String description = "绕地球一圈";
        int status = 1;
        int id = 4;


        //1. 获取Connection
        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5. 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        //2. 定义SQL
        String sql = " update tb_brand\n" +
                "         set brand_name  = ?,\n" +
                "         company_name= ?,\n" +
                "         ordered     = ?,\n" +
                "         description = ?,\n" +
                "         status      = ?\n" +
                "     where id = ?";

        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4. 设置参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);
        pstmt.setInt(6, id);

        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数
        //6. 处理结果
        System.out.println(count > 0);


        //7. 释放资源
        pstmt.close();
        conn.close();
    }

    @Test
    public void testDeleteById() throws Exception {
        //接收页面提交的参数
        int id = 4;

        //1. 获取Connection
        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5. 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        //2. 定义SQL
        String sql = " delete from tb_brand where id = ?";

        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4. 设置参数

        pstmt.setInt(1,id);

        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数
        //6. 处理结果
        System.out.println(count > 0);


        //7. 释放资源
        pstmt.close();
        conn.close();

    }
}
