package com.bu.baseGrammer;

import java.math.BigDecimal;
/**
 * 1/1+1/2+...+1/20的和
 * @author Administrator
 *
 */
public class Exampletext {
	public static void main(String[] args) {
		textExample();
	}
	
	private static void textExample(){
		
		BigDecimal sum=new BigDecimal(0.0);
		BigDecimal factorial = new BigDecimal(1.0);
		
		int i=1;
		while(i<=20){
			sum= sum.add(factorial);
			i++;
			factorial=factorial.multiply(new BigDecimal(1.0/i));
		}
		System.out.println("结果等于"+sum);
	}
}
