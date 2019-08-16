package com.family.springMvcTest;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author: gzb
 * @date  : 2019年8月14日 下午4:49:22
 *
 */
public class RequestMapingMap {
    /**
    * @Field: requesetMap
    *          用于存储方法的访问路径
    */ 
    private static Map<String, Class<?>> requesetMap = new HashMap<String, Class<?>>();
    
    public static Class<?> getClassName(String path) {
        return requesetMap.get(path);
    }

    public static void put(String path, Class<?> className) {
        requesetMap.put(path, className);
    }

    public static Map<String, Class<?>> getRequesetMap() {
        return requesetMap;
    }
}
