package com.family.ClassFanShe;

import java.lang.reflect.Method;

/**
 * @author: gzb
 * @date  : 2019年7月26日 下午8:09:04
 *
 */
public class MethodClass {
    public static void main(String[] args) throws Exception {
        //1.获取Class对象
        Class stuClass = Class.forName("com.family.ClassFanShe.Student3");
        
        MethodClass m=new MethodClass();
        m.getNoParamPrivateMethod(stuClass);
    }
    //获取所有公有方法
    private void getAllPublicMethod(Class stuClass) {
        System.out.println("***************获取所有的”公有“方法*******************");
        Method[] methodArray = stuClass.getMethods();
        for(Method m : methodArray){
            System.out.println("您好："+m);
        }
    }
    //获取所有的方法，包括私有的
    private void getAllMethod(Class stuClass) {
        System.out.println("***************获取所有的方法，包括私有的*******************");//getAllMethod
        Method[]methodArray = stuClass.getDeclaredMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
    }
    //获取公有的show1()方法
    private void getPublicMethod(Class stuClass)throws Exception {
        System.out.println("***************获取公有的show1()方法*******************");//getPublicMethod
        Method m = stuClass.getMethod("show2", String.class);
        System.out.println(m);
        //实例化一个Student对象
        Object obj = stuClass.getConstructor().newInstance();
        Object invoke = m.invoke(obj, "刘德华");
        System.out.println("返回值：" + invoke);
    }
    
    //获取私有的show4()方法
    private void getPrivateMethod(Class stuClass) throws Exception {
        Object obj = stuClass.getConstructor().newInstance();
        
        System.out.println("***************获取私有的show4()方法******************");//getPrivateMethod
        Method m = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);//解除私有限定
        Object result = m.invoke(obj, 20);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);
    }
    
    //获取私有的show5()方法，无参
    private void getNoParamPrivateMethod(Class stuClass) throws Exception {
        Object obj = stuClass.getConstructor().newInstance();
        
        System.out.println("***************获取私有的show5()方法******************");//getPrivateMethod
        Method m = stuClass.getDeclaredMethod("show5");
        System.out.println(m);
        m.setAccessible(true);//解除私有限定
        Object result = m.invoke(obj);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);
    }
}
































