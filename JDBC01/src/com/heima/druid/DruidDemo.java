package com.heima.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1 导入JAR包
        //2 定义配置文件
//3 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\shinelon\\Desktop\\学习过程文件\\JDBC\\JDBC01\\src\\druid.properties"));
        //4 获取连接池对象

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
