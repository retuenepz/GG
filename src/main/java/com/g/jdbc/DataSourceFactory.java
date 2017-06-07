package com.g.jdbc;

import com.g.jdbc.datasource.BasicDataSourceImpl;
import com.g.model.ConnectionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 根据properties 来加载数据源
 * Created by hongyb on 2017/5/25.
 */
public final class DataSourceFactory {

    private static final Logger LOG = LoggerFactory.getLogger(DataSourceFactory.class);
    /**
     * properties keys
     */
    private static final String DRIVER_KEY= "G.jdbc.driver";
    private static final String URL_KEY = "G.jdbc.url";
    private static final String USERNAME_KEY = "G.jdbc.username";
    private static final String PASSWORD_KEY="G.jdbc.password";
    private static ConnectionConfig connConfig = new ConnectionConfig();
    /**
     * 数据库连接信息
     */

    static{
        // 读取jdbc.properties配置文件
        InputStream resourceAsStream = DataSourceFactory.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        
        try {
            pro.load(resourceAsStream);
            connConfig.setDriver((String) pro.get(DRIVER_KEY));
            connConfig.setUrl((String) pro.get(URL_KEY));
            connConfig.setUsername((String) pro.get(USERNAME_KEY));
            connConfig.setPassword((String) pro.get(PASSWORD_KEY));
        } catch (IOException e) {
            e.printStackTrace();
            LOG.debug("没有找到配置文件 jdbc.properties");
        }
    }



    public static DataSource getDataSource(){
        return new BasicDataSourceImpl(connConfig) ;
    }
}
