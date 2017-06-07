package com.g.model;

import com.g.annotation.Table;

/**
 * Created by hongyb on 2017/5/19.
 */
@Table(name="tableName",pk="PK")
public class User {
    private String name ;
    private String password ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
