package com.g.jdbc.datasource;

import com.g.model.ConnectionConfig;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * 就是一个最基本的JDBC链接，没有连接池，连接池太他妈难了。
 * Created by hongyb on 2017/5/31.
 */
public class BasicDataSourceImpl implements DataSource {
    /**
     * 日志
     */
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(BasicDataSourceImpl.class);
    /**
     * getLogWriter 返回的东西
     */
    private PrintWriter logWriter ;
    /**
     * 数据库登录超时时间，单位：秒
     */
    private int loginTimeout ;
    /**
     * 数据库链接信息
     */
    private ConnectionConfig connConfig ;

    public BasicDataSourceImpl(ConnectionConfig connConfig) {
        this.connConfig = connConfig ;
        try {
            Class.forName(connConfig.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(connConfig.getUrl(), connConfig.getUsername(), connConfig.getPassword());
        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return getConnection();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        LOG.debug("本实现不支持代理！");
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        LOG.debug("本实现不支持代理！");
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return logWriter;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        this.logWriter=out;
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        this.loginTimeout=seconds;
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return loginTimeout;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        LOG.debug("不支持这个方法！");
        return null;
    }
}
