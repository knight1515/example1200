package com.family.algorithem_1907;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumLoop {
    public static void main(String[] args) throws IOException {
        getSumLoop4();
    }
    
    /**
     * 方法一
     * 求s=a+aa+aaa+aaaa+aa...a的值
     * @throws IOException
     */
    private static void getSumLoop2() throws IOException {
        int s=0;
        String outPut="";
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入a的值");
        String input=br.readLine();
        for(int i=0;i<=Integer.parseInt(input);i++) {
            outPut+=input;
            int a=Integer.parseInt(outPut);
            s+=a;
        }
        System.out.println(s);
    }
    
    /**
     * 方法二
     * 求s=a+aa+aaa+aaaa+aa...a的值
     * @throws IOException 
     */
    private static  void getSumLoop3() throws IOException {
        int s=0;
        int n;
        int t=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入数字");
        String input=br.readLine();
        n=Integer.parseInt(input);
        for(int i=1;i<=n;i++) {
            t=t*10+n;
            s=s+t;
            System.out.println(t);
        }
        System.out.println(s);
    }
    
    /**
     * 练习用题
     * @throws IOException 
     */
    private static void getSumLoop() throws IOException {
        int s=0;
        String outPut="";
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入要求和的数字");
        String inPut=br.readLine();
        for(int i=0;i<=Integer.parseInt(inPut);i++) {
            outPut+=inPut;
            s+=Integer.parseInt(outPut);
        }
        System.out.println(s);
    }
    
    private static void getSumLoop4() throws IOException {
        int s=0;
        int a=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入求和的数字");
        String aOld=br.readLine();
        int ba=Integer.parseInt(aOld);
        for(int i=1;i<=ba;i++) {
            a=a*10+ba;
            s+=a;
        }
        System.out.println(s);
    }
}































