package com.g.jdbc;

import org.sql2o.Sql2o;

import javax.sql.DataSource;

/**
 * SQL20 工厂
 * 用来执行SQL的，是JDBC的上层封装
 * Created by hongyb on 2017/6/1.
 */
public class Sql2OFactory {

    public static Sql2o getInstance(DataSource dataSource){
        return new Sql2o(dataSource);
    }
    public static Sql2o getInstance(String url,String username ,String password){
        return new Sql2o(url,username,password);
    }

}
