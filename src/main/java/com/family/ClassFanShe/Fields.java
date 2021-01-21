package com.family.ClassFanShe;

import java.lang.reflect.Field;

/**
 * @author: gzb
 * @date  : 2019年7月26日 下午5:42:30
 *
 */
    /*
     * 获取成员变量并调用：
     * 
     * 1.批量的
     *      1).Field[] getFields():获取所有的"公有字段"
     *      2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
     * 2.获取单个的：
     *      1).public Field getField(String fieldName):获取某个"公有的"字段；
     *      2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
     * 
     *   设置字段的值：
     *      Field --> public void set(Object obj,Object value):
     *                  参数说明：
     *                  1.obj:要设置的字段所在的对象；
     *                  2.value:要为字段设置的值；
     * 
     */
public class Fields {

    public static void main(String[] args) throws Exception {
        //1.获取Class对象
        Class stuClass = Class.forName("com.family.ClassFanShe.Student2");

        Fields f=new Fields();
        f.getAllField(stuClass);
    }
    
    //获取所有公有的字段
    private void getAllPublicField(Class stuClass) {
        System.out.println("************获取所有公有的字段********************");//getAllPublicField
        Field[] fieldArray = stuClass.getFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }
    }
    //获取所有的字段(包括私有、受保护、默认的)
    private void getAllField(Class stuClass) {
        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");//getAllField
        Field[] fieldArray = stuClass.getDeclaredFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }
    }
    //获取公有字段**并调用
    private void getPublicField(Class stuClass)throws Exception {
        System.out.println("*************获取公有字段**并调用***********************************");//getPublicField
        Field f = stuClass.getField("name");
        System.out.println(f);
        //获取一个对象
        Object obj = stuClass.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
        //为字段设置值
        f.set(obj, "刘德华");//为Student对象中的name属性赋值--》stu.name = "刘德华"
        //验证
        Student2 stu = (Student2)obj;
        System.out.println("验证姓名：" + stu.name);
    }
    //获取私有字段****并调用
    private void getPrivateField(Class stuClass)throws Exception {
        //获取一个对象
        Object obj = stuClass.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
        Student2 stu = (Student2)obj;
        System.out.println("**************获取私有字段****并调用********************************");//getPrivateField
        Field f = stuClass.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true);//暴力反射，解除私有限定
        f.set(obj, "18888889999");
        System.out.println("验证电话：" + stu);
    }
    
}



























