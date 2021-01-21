package com.bu.baseGrammer;

import java.util.Scanner;

public class ParityCheck {
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("请输入一个整数：");
		long number=scan.nextLong();
		String check=(number%2==0)?"你输入了一个偶数。":"你输入了一个奇数";
		System.out.println(check);
	}
	
}
