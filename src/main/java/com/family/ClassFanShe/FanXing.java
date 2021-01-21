package com.family.ClassFanShe;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 反射方法的其它使用之—通过反射越过泛型检查
 * @author: gzb
 * @date  : 2019年7月27日 上午10:33:27
 *
 */
public class FanXing {
    public static void main(String[] args) throws Exception{
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");

    //  strList.add(100);
        //获取ArrayList的Class对象，反向的调用add()方法，添加数据
        Class listClass = strList.getClass(); //得到 strList 对象的字节码 对象
        //获取add()方法
        Method m = listClass.getMethod("add", Object.class);
        //调用add()方法
        m.invoke(strList, 100);

        //遍历集合
        for(Object obj : strList){
            System.out.println(obj);
        }
    }
}
