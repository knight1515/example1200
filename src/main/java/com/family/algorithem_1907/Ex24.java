package com.family.algorithem_1907;

import org.junit.Test;

import java.util.Scanner;

public class Ex24 {
    static int[] a =new int[5];
    static int[] b=new int[5];
    
    public static void main(String[] args) {
        Ex24 tn=new Ex24();
        boolean  is=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入求取的值！");
        long l=sc.nextLong();
        while (l<10000||l>99999) {
          System.out.println("Input error,please input again!");
          l=sc.nextLong();
        }
        for(int i=4;i>=0;i--) {
            a[i]=(int)(l/(long)Math.pow(10, i));
            l=(l%(long)Math.pow(10, i));
        }
        for(int i=0, j=0;i<5;i++,j++) {
            b[j]=a[i];
        }
        for(int i=0,j=4;i<5;i++,j--) {
            if (a[i]!=b[j]) {
                is=false;
                break;
            }else {
                is=true;
            }
        }
        
        if (is==false) {
            System.out.println("is not a Palindrom!");
        }else {
            System.out.println("is a Palindrom!");
        }
        
        
        
        
        
        
//        Scanner sc=new Scanner(System.in);
//        long a =sc.nextLong();
//        if(a<0||a>100000) {
//            System.out.println("Error Input,please run this program Again");
//            System.exit(0);
//        }
//        if (a>=0&&a<=9) {
//            System.out.println( a+"是一位数");
//            System.out.println("按逆序输出是"+'\n'+a);
//        }else if(a>=10&&a<99) {
//            System.out.println(a+"是二位数");
//            System.out.println("按逆序输出是:");
//            tn.converse(a);
//        }else if(a>=100&&a<999) {
//            System.out.println(a+"是三位数");
//            System.out.println("按逆序输出是：");
//            tn.converse(a);
//        }else if(a>=1000&&a<9999) {
//            System.out.println(a+"是四位数");
//            System.out.println("按逆序输出是：");
//            tn.converse(a);
//        }else if(a>=10000&&a<99999) {
//            System.out.println(a+"是五位数");
//            System.out.println("按逆序输出是：");
//            tn.converse(a);
//        }
        
//        Scanner sc=new Scanner(System.in);
//        System.out.println("请输入要计算的数据");
//        long a=sc.nextLong();
//        tn.huiWen(a);
    }

    @Test
    private void converse() {
        long l = 12L;
        String s=Long.toString(l);
        char[] ch=s.toCharArray();
        for(int i=ch.length-1;i>=0;i--) {
            System.out.println(ch[i]);
        }
    }
    
    /**
     * 计算回文数。
     * @param l
     */
    private  void huiWen(long l) {
       String  lString=Long.toString(l);
       char[] ch=lString.toCharArray();
       int temp=0;
       for(int i=0;i<ch.length/2;i++) {
           if (ch[i]!=ch[ch.length-1-i]) {
               temp=1;
        }
       }
       if (temp!=1) {
        System.out.println(l+"是回文数");
       }else {
        System.out.println(l+"不是回文数！");
    }
    }
}













