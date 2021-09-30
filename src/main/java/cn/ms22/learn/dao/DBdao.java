package cn.ms22.learn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class DBdao {
    @Autowired
    private DataSource dataSource;

    public String accessH2ReadInfo() throws SQLException {
        Connection connection = dataSource.getConnection();
        String connectionMsg = connection.toString();
        connection.close();
        return "read dataSource before" + dataSource.toString() + connectionMsg;
    }
}
