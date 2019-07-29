package com.family.ClassFanShe;

/**
 * @author: gzb
 * @date  : 2019年7月26日 下午5:41:10
 *
 */
public class Student2 {
    public Student2(){

    }
    //**********字段*************//
    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    @Override
    public String toString() {
        return "Student2 [name=" + name + ", age=" + age + ", sex=" + sex
                + ", phoneNum=" + phoneNum + "]";
    }

}
