package com.family.algorithem_1907;

import java.math.BigDecimal;

import com.family.algorithm_1906.ZhiYinShu;

public class CalculateAltitude {
    public static void main(String[] args) {
        CalculateAltitude ca=new CalculateAltitude();
        ca.calculate1(new Double(100), 10);
//        ca.calculate2();
    }
    
    //预留小数要留足够
    private void calculate1(Double altitude,int number) {
        BigDecimal base=new BigDecimal(2);
        BigDecimal sum=new BigDecimal(0);
        BigDecimal altitudeBig=new BigDecimal(altitude);
        for(int i=0;i<number;i++) {
            sum=sum.add(altitudeBig);
            altitudeBig=altitudeBig.divide(base,2,BigDecimal.ROUND_HALF_UP);//累计除法预留小数点要大一点
        }
        
        System.out.println("原始高度在"+altitude+"的小球，经过"+number+"次的跳动，共经过"+sum+"米，最终高度为:"+altitudeBig);
        calculate2(altitude,number);
    }
    
       //用double除法挺好的。
    private void calculate2(double t,int number) {
        double   s=0; 
//        double   t=100; 
        for(int   i=1;i <=number;i++) 
        { 
                        s+=t; 
                        t=t/2; 
        } 
        System.out.println(s); 
        System.out.println(t); 
    }
}
