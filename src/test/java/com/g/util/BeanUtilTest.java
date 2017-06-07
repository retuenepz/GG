package com.g.util;

import com.g.model.UserTest;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.PropertyDescriptor;

/**
 * Created by hongyb on 2017/5/19.
 */
public class BeanUtilTest {
    /**
     * 内省测试
     */
    @Test
    public void testBeanUtil() {
        BeanInfo beanInfo = BeanUtil.getBeanInfo(UserTest.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
            String name = propertyDescriptor.getName();
            Object value = propertyDescriptor.getValue(name);
            System.out.println(name + value);
        }
    }
    @Test
    public void testgetAllBeanInfo(){
        BeanInfo beanInfo = BeanUtil.getAllBeanInfo(UserTest.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
            String name = propertyDescriptor.getName();
            Object value = propertyDescriptor.getValue(name);
            System.out.println(name + value);
        }
    }
}
