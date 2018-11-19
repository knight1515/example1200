package com.bu.baseGrammer;

import java.util.Scanner;

/**
 * 判断是否闰年
 * 能被4整除，不被100整除，或者能被400整除
 * @author Administrator
 *
 */
public class LeapYear {
	public static void main(String[] args) {
		testLeapYear();
	}
	
	private static void testLeapYear(){
		Scanner scan=new Scanner(System.in);
		
		System.out.println("请输入你要查询的年份：");
		
		long year= scan.nextLong();
		
		if((year%4==0&&year%100!=0)||year%400==0){
			System.out.println("您输入的"+year+"年，是闰年");
		}else {
			System.out.println("您输入的"+year+"年，不是闰年");
		}
	}
}
