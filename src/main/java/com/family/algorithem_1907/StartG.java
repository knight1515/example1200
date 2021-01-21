package com.family.algorithem_1907;

/**
 * 1、画菱形
 * 2、求分数，数列和：2/1，3/2，5/3，8/5，13/8，21/13...
 * @author hp
 *
 */
public class StartG {
    public static void main(String[] args) {
        StartG sg=new StartG();
        sg.calculate4();
    }
    /*
     *
*   
***   
******   
********   
******   
***   
*

     */
    private void calculate2() {
        int i=0;
        int j=0;
        for(i=1;i<=4;i++) {
            for(j=1;j<2*i-1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(i=4;i>=1;i--) {
            for(j=1;j<2*i-3;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    private void calculate3() {
        int i=0;
        int j=0;
        for(i=1;i<=4;i++) {
            for(int k=1;k<=4-i;k++) {
                System.out.print(" ");
            }
            for(j=1;j<2*i-1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        for(i=4;i>=1;i--) {
            for(int k=1;k<=5-i;k++) {
                System.out.print(" ");
            }
            for(j=1;j<2*i-3;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
    /**
     * 求前20位的和
     */
    private void calculate4() {
        float fm=1f;
        float fz=1f;
        float temp;
        float sum=0f;
        for(int i=0;i<20;i++) {
            temp=fm;
            fm=fz;
            fz=fm+temp;
            sum+=fz/fm;
        }
        System.out.println(sum);
    }
    
    private void calculate5() {
        float fz=1f;
        float fm=1f;
        float tmpt;
        float sum=0f;
        for(int i=0;i<20;i++) {
            tmpt=fm;
            fm=fz;
            fz=fm+tmpt;
            sum+=fz/fm;
        }
        System.out.println(sum);
    }
    
    private void calculate6() {
        float fz=1f;
        float fm=1f;
        float temp;
        float sum=0f;
        for(int i=0;i<20;i++) {
            temp=fm;
            fm=fz;
            fz=fm+temp;
            sum +=fz/fm;
        }
        System.out.println(sum);
    }
}

















