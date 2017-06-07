package com.g.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by hongyb on 2017/5/18.
 * 哇哈哈哈   内省工具
 * 哥哥自带缓存，如果类的Class对象呗回收 相应的BeanInfo也会被回收掉 。
 */
public class BeanUtil {
    /**
     * 日志-_-志日
     */
//    private static final Logger LOGGER = LoggerFactory.getLogger(BeanUtil.class);
    /**
     * 缓存容器，弱引用容器，当KEY被垃圾回收的时候，VALUE也会被回收。
     */
    private static final Map<Class<?> ,BeanInfo> classCache = Collections.synchronizedMap(new WeakHashMap<Class<?>, BeanInfo>()) ;

    /**
     * 获取BeanInfo
     * @param clazz
     * @param stopClazz
     * @return
     */
    public static BeanInfo getBeanInfo(Class<?> clazz,Class<?> stopClazz){
        BeanInfo beanInfo = null ;
        try {
            if(classCache.get(clazz)==null){
                beanInfo = Introspector.getBeanInfo(clazz,stopClazz);
                classCache.put(clazz,beanInfo);
                // 由于Introspector内部的缓存采用的不是弱引用缓存，对GC不够友好，所以把他的缓存清掉，用我们自己的缓存
                Class<?> classToFlush = clazz ;
                do {
                    Introspector.flushFromCaches(classToFlush);
                    classToFlush = classToFlush.getSuperclass();
                } while(classToFlush != null );
            }else{
                beanInfo = classCache.get(clazz);
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return beanInfo;
    }

    /**
     * 返回参数clazz的BeanInfo 不包含父类属性
     * @param clazz
     * @return
     */
    public static BeanInfo getBeanInfo(Class<?> clazz){
        return getBeanInfo(clazz,clazz.getSuperclass());
    }

    /**
     * 返回参数clazz的BeanInfo 包含所有父类属性
     * @param clazz
     * @return
     */
    public static BeanInfo getAllBeanInfo(Class<?> clazz){
        return getBeanInfo(clazz,Object.class);
    }
}
