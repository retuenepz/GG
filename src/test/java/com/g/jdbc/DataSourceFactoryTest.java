package com.g.jdbc;

import org.junit.Assert;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hongyb on 2017/5/31.
 */
public class DataSourceFactoryTest {
    @Test
    public void getDataSource() throws SQLException {
        DataSource dataSource = DataSourceFactory.getDataSource();
        Connection connection = dataSource.getConnection();
        Assert.assertNotNull(connection);
    }
}
