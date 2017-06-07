package com.g.model;

import com.g.annotation.Table;

/**
 * @Table 测试类
 * Created by hongyb on 2017/5/19.
 */
@Table(name="UserTestModel",pk="TestPK")
public class UserTest {
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
