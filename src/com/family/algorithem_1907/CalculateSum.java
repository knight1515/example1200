package com.family.algorithem_1907;

import java.util.Scanner;

public class CalculateSum {
    
    public static void main(String[] args) {
        CalculateSum cs=new CalculateSum();
//        cs.getSum();
        
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入：");
        int n=sc.nextInt();
        long calculate2 = cs.calculateAge(n);
        System.out.println(calculate2);
    }
    /**
     * 求1+2!+3!+...+20!的和
     */
    private void getSum() {
        long sum=0;
        long fac=1;
        for(int i=1;i<=4;i++) {
            fac=fac*i;
            sum+=fac;
        }
        System.out.println(sum);
    }
    
    private void getSum2() {
        long sum=0;
        long fac=1;
        for(int i=1;i<=4;i++) {
            fac=fac*i;
            sum+=fac;
        }
    }
    
    /**
     * 利用递归方法求5!。
     */
    private long calculate2(int n) {
        
        long value=0;
        if(n==1 || n==0) {
            value =1;
        }else if(n>1){
            value=n*calculate2(n-1);
        }
        return value;
    }
    
    private long calculateAge(int n) {
        long value=0;
        if (n==1) {
            value=10;
        }else if(n>1){
            value=2+calculateAge(n-1);
        }
        return value;
    }
}



















