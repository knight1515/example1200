package com.bu.baseGrammer;

import java.util.Scanner;

/**
 * 利用左右移位实现乘法运算
 * @author Administrator
 *
 */
public class Example {

	public static void main(String[] args) {
		testThree();
	}
	
	//乘以2
	private static void multiply2(){
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入一个数字");
		long number=scan.nextLong();
		System.out.println("您输入的数字是："+number);
		System.out.println("乘以2等于："+(number<<1));
		System.out.println("乘以4等于："+(number<<2));
		System.out.println("乘以8等于："+(number<<3));
		System.out.println("乘以16等于："+(number<<4));
	}
	
	//除以2
	private static void testDivide(){
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入一个数字");
		long number=scan.nextLong();
		System.out.println("您输入的数字是："+number);
		System.out.println("除以2等于："+(number>>1));
		System.out.println("除以4等于："+(number>>2));
		System.out.println("除以8等于："+(number>>3));
		System.out.println("除以16等于："+(number>>4));
		
	}
	
	private static void testThree(){
		Scanner scan=new Scanner(System.in);
		System.err.println("请输入一个数字");
		long number=scan.nextLong();
		System.out.println("您输入的数字是："+number);
		System.out.println("乘以3等于："+((number<<1)+number));
		System.out.println("乘以9等于："+((number<<2)+(number<<1)+number));
		System.err.println("乘以27等于："+((number<<3)+(number<<2)+(number<<1)+number));
		System.err.println("乘以81等于："+((number<<4)+(number<<3)+(number<<2)+(number<<1)+number));
	}
}
