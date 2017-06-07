package com.g.core.impl;

import com.g.annotation.Table;
import com.g.core.NameHandler;

import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  用来处理 @Table 注解
 *  获取注解属性值
 * Created by hongyb on 2017/5/19.
 */
public class DefaultNameHandler implements NameHandler {

    @Override
    public String getName(Class<?> entity) {
        if(null != entity){
            Table annotation = entity.getAnnotation(Table.class);
            if(null != annotation){
                return annotation.name();
            }
        }
        return null;
    }

    @Override
    public String getPK(Class<?> entity) {
        if(null != entity){
            Table annotation = entity.getAnnotation(Table.class);
            if(null != annotation){
                return annotation.pk();
            }
        }
        return null;
    }
}
