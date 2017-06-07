package com.g.model;

/**
 * 数据库连接信息
 * Created by hongyb on 2017/5/31.
 */
public class ConnectionConfig {
    private static String driver = "";
    private static String url ="";
    private static String  username  = "" ;
    private static String password="";

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        ConnectionConfig.driver = driver;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ConnectionConfig.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        ConnectionConfig.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ConnectionConfig.password = password;
    }
}
