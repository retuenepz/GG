package com.g.jdbc;

import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.data.Table;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 学习一下sql2o
 * Created by hongyb on 2017/6/1.
 */
public class Sql2oFactoryTest {
    private Sql2o instance;
    @Before
    public void init(){

        instance = Sql2OFactory.getInstance(DataSourceFactory.getDataSource());
    }
    // 查询
    @Test
    public void query(){
        String sql = "select id,name,password,lastdate from user ";
        Connection conn = instance.open();
        List<User> users = conn.createQuery(sql).executeAndFetch(User.class);
        for (User user : users) {
            System.out.println(user);
        }
    }

    // 参数使用
    @Test
    public void  queryWithParameter(){
        Date now = new Date();
        String sql = "select id,name,password,lastdate from user where lastdate >= :now";
        Connection conn = instance.open();
        List<User> res = conn.createQuery(sql).addParameter("now", now).executeAndFetch(User.class);
        for (User user :res) {
            System.out.println(user);
        }
    }

    // 返回单个值的情况。
    @Test
    public void queryCount(){
        String sql = "select count(1) from user";
        Connection conn = instance.open();
        Integer count = conn.createQuery(sql).executeScalar(Integer.class);
        System.out.println(count);
    }
    // list 单值
    @Test
    public void queryListScalar(){
        String sql = "select id from user";
        Connection conn = instance.open();
        List<String> ids = conn.createQuery(sql).executeAndFetch(String.class);
        for (String s : ids ) {
            System.out.println(s);
        }
    }
    @Test
    public void queryListMap(){
        String sql="select id, name,password,lastdate from user ";
        Connection connection = instance.open();
        List<Map<String, Object>> maps = connection.createQuery(sql).executeAndFetchTable().asList();
        for (Map<String,Object> map: maps) {
            System.out.println(map);
        }
    }
    // 单次column mappint
    @Test
    public void columnMappingOne(){
        String sql = "select id , name as user , password ,lastdate from user" ;
        Connection conn = instance.open();
        List<User> users = conn.createQuery(sql).addColumnMapping("user", "name").executeAndFetch(User.class);
        for (User user : users) {
            System.out.println(user);
        }
    }
    // 这个是全局的column mapping
    @Test
    public void columnMappingAll(){
        HashMap<String, String> mapping = new HashMap<>();
        mapping.put("user","name");
        instance.setDefaultColumnMappings(mapping);
    }
    @Test
    public void update(){
        String sql = "update user set name=:name where id=:id" ;
        Connection conn = instance.open();
        conn.createQuery(sql).addParameter("name", "jack").addParameter("id", "6").executeUpdate();
    }
    @Test
    public void insert(){
        String sql="insert into user(id,name,password,lastdate) values(:id,:name,:password,:lastdate)";
        try(Connection conn = instance.open()){
            conn.createQuery(sql).addParameter("id","7").addParameter("name","maggie").addParameter("password","xixi").addParameter("lastdate",new Date()).executeUpdate();
        }
    }
    @Test
    public void insertAndGetId(){
        String sql = "insert into user(name) values(:name)";
        try(Connection conn = instance.open()){
           long key = (long) conn.createQuery(sql, true).addParameter("name", "test").executeUpdate().getKey();
            System.out.println(key);
        }
    }
    @Test
    public void insertBind(){
        User user = new User();
        user.name="xiaoming";
        user.password="123456";
        user.lastdate=new Date();
        String sql = "insert into user(name,password,lastdate) values(:name,:password,:lastdate)";
        Connection conn = instance.open();
        conn.createQuery(sql).bind(user).executeUpdate();
    }

    public void transaction(){

        try(Connection conn = instance.beginTransaction())
        {
            // insert
            // update
            //xxx
            conn.commit();
        }
    }
    private class User{
        public String id ;
        public String name;
        public String password ;
        public Date lastdate ;

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    ", lastdate=" + lastdate +
                    '}';
        }
    }
}
