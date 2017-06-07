package com.g.core;

/**
 * Created by hongyb on 2017/5/19.
 */
public interface NameHandler {
    /**
     * 获取@Table注解的name属性
     * @param entity
     * @return 如果没有就返回null
     */
    String getName(Class<?> entity);

    /**
     * 获取  @Table 注解的 pk 属性值
     * @param entity
     * @return
     */
    String getPK(Class<?> entity);
}
