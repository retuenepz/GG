package com.g.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Author hongyb -_-
* @Date 2017/5/19 15:53
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    /**
     * 名称
     * @return
     */
    String name() default "";
    String pk() default "id";
}
