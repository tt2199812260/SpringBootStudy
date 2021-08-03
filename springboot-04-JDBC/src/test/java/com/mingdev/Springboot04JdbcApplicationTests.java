package com.mingdev;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04JdbcApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //查看数据源 ：com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());

        //获取数据库连接
        Connection connection =dataSource.getConnection();
        System.out.println(connection); //com.mysql.cj.jdbc.ConnectionImpl@3a1706e1

        // XXXX Template  SpringBoot已经配置好的模板 Bean 可以直接使用

        //关闭连接
        connection.close();
    }

}
