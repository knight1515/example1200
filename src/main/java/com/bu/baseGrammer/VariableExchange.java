package com.bu.baseGrammer;

import java.util.Scanner;
/**
 * 利用异或^，不用中间变量交换A、B两者的值
 * @author Administrator
 *
 */
public class VariableExchange {
	public static void main(String[] args) {
		textChange();
		
	}
	
	private static void textChange(){
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入变量A的值");
		long A=scan.nextLong();
		System.out.println("请输入变量B的值");
		long B=scan.nextLong();
		
		System.out.println("你输入的A="+A+"\tB="+B);
		
		A=A^B;
		B=A^B;
		A=A^B;
		
		System.out.println("操作后的A="+A+"\tB="+B);
	}
}
