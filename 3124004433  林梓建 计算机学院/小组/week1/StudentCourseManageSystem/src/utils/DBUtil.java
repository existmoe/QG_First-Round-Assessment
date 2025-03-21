package utils;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static final DruidDataSource dataSource = new DruidDataSource();

    static {
        // 配置数据源
        dataSource.setUrl("jdbc:mysql://localhost:3306/StudentCourseManagementSystem?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("52Lzj1314@");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // 配置连接池
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(5);
        dataSource.setMaxWait(60000);
    }
    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    //
    public static DataSource getDataSource() {
        return dataSource;
    }
}