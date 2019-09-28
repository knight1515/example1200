package com.family.algorithem_1907;

import java.util.Scanner;

public class CalculateProfit {
    public static void main(String[] args) {
        CalculateProfit cp=new CalculateProfit();
//        cp.getProfit(100023);
//        cp.getProfit2();
        cp.calculateNum();
        
    }
    
    /**
     * 利润(I)低于或等于10万元时，奖金可提10%；利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，
     * 可提成7.5%；20万到40万之间时，高于20万元的部分，可提成5%；40万到60万之间时高于40万元的部分，可提成3%；60万到100万之间时，
     * 高于60万元的部分，可提成1.5%，高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润I，求应发放奖金总数？   
     * @param sale
     */
    private void getProfit(double sale) {
        double sum=0;
        if (sale<=100000) {
            sum=sale*0.1;
        }else if(sale<=200000&&sale>100000) {
            sum=100000*0.1;
            sum+=(sale-100000)*0.075;
        }else if(sale>200000&&sale<=400000) {
            sum=100000*0.1;
            sum+=(200000-100000)*0.075;
            sum+=(sale-200000)*0.05;
        }else if(sale<=600000&&sale>400000) {
            sum=100000*0.1;
            sum+=(200000-100000)*0.075;
            sum+=(400000-200000)*0.05;
            sum+=(sale-400000)*0.03;
        }else if(sale>600000&&sale<=1000000) {
            sum=100000*0.1;
            sum+=(200000-100000)*0.075;
            sum+=(400000-200000)*0.05;
            sum+=(600000-400000)*0.03;
            sum+=(sale-600000)*0.015;
        }else if(sale>200000) {
            sum=100000*0.1;
            sum+=(200000-100000)*0.075;
            sum+=(400000-200000)*0.05;
            sum+=(600000-400000)*0.03;
            sum+=(1000000-600000)*0.015;
            sum+=(sale-1000000)*0.01;
        }
        System.out.println("销售额为："+sale+"时，利润为："+sum);
    }
    
    /**
     * 错的方法
     */
    private void getProfit2() {
        double sum;//声明要储存的变量应发的奖金 
        Scanner input =new Scanner (System.in);//导入扫描器 
        System.out.print ("输入当月利润"); 
        double lirun=input .nextDouble();//从控制台录入利润 
        if(lirun<=100000){ 
            sum=lirun*0.1; 
        }else if (lirun<=200000){ 
            sum=10000+lirun*0.075; 
        }else if (lirun<=400000){ 
            sum=17500+lirun*0.05; 
        }else if (lirun<=600000){ 
            sum=lirun*0.03; 
        }else if (lirun<=1000000){ 
            sum=lirun*0.015; 
        } else{ 
            sum=lirun*0.01; 
        } 
        System.out.println("应发的奖金是"+sum); 

    }
    
    private void calculateNum() {
        long k=0;
        for(k=1;k<=10000012;k++) {
            double sqrt = Math.sqrt(k+100);//开放
            double floor = Math.floor(sqrt);//退一法
            
            double sqrt2 = Math.sqrt(k+168);
            double floor2 = Math.floor(sqrt2);
            if (sqrt==floor&&sqrt2==floor2) {
                System.out.println(k);
            }
            
        }
    }
}
