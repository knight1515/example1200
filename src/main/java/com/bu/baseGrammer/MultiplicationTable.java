package com.bu.baseGrammer;

public class MultiplicationTable {
	public static void main(String[] args) {
		textMultiplication();
	}
	
	/**
	 * 测试99乘法表
	 */
	private static void textMultiplication(){
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(i+"*"+j+" = "+i*j+"  ");
			}
			System.out.println();
		}
	}
}
