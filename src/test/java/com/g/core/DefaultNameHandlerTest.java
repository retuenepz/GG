package com.g.core;

import com.g.core.impl.DefaultNameHandler;
import com.g.model.UserTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * 测试获取@Table注解 值
 * Created by hongyb on 2017/5/19.
 */
public class DefaultNameHandlerTest {
    @Test
    public void getName(){
        NameHandler handler = new DefaultNameHandler();
        UserTest userTest = new UserTest();
        String name = handler.getName(userTest.getClass());
        Assert.assertEquals("UserTestModel",name);
    }
    @Test
    public void getPK(){
        NameHandler handler = new DefaultNameHandler();
        UserTest userTest = new UserTest();
        String pk = handler.getPK(userTest.getClass());
        Assert.assertEquals("TestPK",pk);
    }
}
