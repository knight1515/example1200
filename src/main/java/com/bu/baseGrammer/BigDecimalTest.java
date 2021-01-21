package com.bu.baseGrammer;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 精确数据的计算用Bigdecimal；因为对于二进制加减会造成误差。
 * 加法：add
 * 减法：subtract
 * 乘法：multiply
 * 除法报错了，不知道为啥。：divide
 * @author Administrator
 */
public class BigDecimalTest {
	public static void main(String[] args) {
		testAdd();
	}
	
	/**
	 * 减法
	 */
	private static void testSubtract(){
		System.out.println("测试BigDecimal的减法应用");
		double monery =2;
		double price=1.1;
		double result=monery-price;
		System.out.println("非精确计算");
		System.out.println("剩余金额："+result);
		
		BigDecimal bigMonert = new BigDecimal(2.2);
		BigDecimal bigPrice = new BigDecimal(1.1);
		BigDecimal subtract = bigMonert.subtract(bigPrice);
		System.out.println("精确计算；");
		System.out.println("剩余金额："+subtract);
	}

	@Test
	public void subtractTest2(){
		System.out.println("测试BigDecimal的减法应用");
		double monery = 2;
		double price = 1.1;
		double result = monery - price;
		System.out.println("非精确计算");
		System.out.println("剩余金额：" + result);

		BigDecimal bigMonert = new BigDecimal(2.2);
		BigDecimal bigPrice = new BigDecimal(1.1);
		BigDecimal subtract = bigMonert.subtract(bigPrice);
		System.out.println("精确计算");
		System.out.println("剩余金额：" + subtract);
	}
	
	/**
	 * 加法
	 */
	private static void testAdd(){
		double monery=2;
		double price=1.1;
		double result=monery*price;
		System.out.println("非Bigdecimla计算");
		System.out.println("计算结果为："+result);
		
		BigDecimal bigMonery=new BigDecimal(2);
		BigDecimal bigPrice=new BigDecimal(1.1);
		BigDecimal multiply = bigMonery.multiply(bigPrice);
		System.out.println("使用Bigdecimal的计算");
		System.out.println("计算结果为："+multiply);
	}
	
	/**
	 * 除法
	 */
	private static void testMultiplicand(){
		double monery=2;
		double price=1.1;
		double result=monery/price;
		System.out.println("非Bigdecimla计算");
		System.out.println("计算结果为："+result);
		
		BigDecimal bigMonery=new BigDecimal(2);
		BigDecimal bigPrice=new BigDecimal(1.1);
		BigDecimal multiply = bigMonery.divide(bigPrice);
		System.out.println("使用Bigdecimal的计算");
		System.out.println("计算结果为："+multiply);
	}
	
	/**
	 * 加法
	 */
	private static void testAddd(){
		double monery=2;
		double price=1.1;
		double d = monery+price;
		System.out.println("非BigDecimal计算的结果");
		System.out.println("计算结果："+d);
		
		BigDecimal bigMonery = new BigDecimal(2);
		BigDecimal bigPrice=new BigDecimal(1.1);
		BigDecimal add = bigMonery.add(bigPrice);
		System.out.println("精确计算BigDecimal的计算结果");
		System.out.print("计算结果为："+add);
	}
}
