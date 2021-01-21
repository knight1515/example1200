package com.family.ClassFanShe;

/**
 * @author: gzb
 * @date  : 2019年7月26日 下午8:08:06
 *
 */
public class Student3 {
    
  //**************成员方法***************//
    public String show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
        return "我是个大人";
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private String show4(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }
    
    private String show5(){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show5(): age = ");
        return "我是无参show5";
    }
    
}
