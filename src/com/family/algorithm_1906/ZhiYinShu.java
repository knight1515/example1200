package com.family.algorithm_1906;

import java.util.ArrayList;
import java.util.List;

public class ZhiYinShu {
	public static void main(String[] args) {
		// List<Integer> primeList=new ArrayList<Integer>();
		// getPrime(111190,2,primeList);
		// for(Integer prime:primeList) {
		// System.out.println(prime);
		// }

		String str = " ";
		ZhiYinShu c = new ZhiYinShu();
		str = javax.swing.JOptionPane.showInputDialog("请输入N的值（输入exit退出）： ");
		int N;
		N = 0;
		try {
			N = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.print(N + "分解质因数： " + N + "= ");
		c.fengjie(N);
		
	}

	/**
	 * 方法一：合数太大时，会出现栈溢出
	 * @param composite
	 * @param prime
	 * @param primeList
	 */
	private static void getPrime(int composite, int prime, List<Integer> primeList) {
		if (composite % prime == 0) {
			if (composite == prime && prime != 2) {
				primeList.add(prime);
			} else {
				primeList.add(prime);
				int composite2 = composite / prime;
				getPrime(composite2, prime, primeList);
			}
		} else {
			prime++;
			if (composite >= prime) {
				getPrime(composite, prime, primeList);
			}
		}
	}
	
	/**
	 * 方法二
	 * @param n
	 */
	public void fengjie(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				System.out.print(i + "* ");
				fengjie(n / i);
			}
		}
		System.out.print(n);
		/**
		 * 一下的作用是每个for循环值执行一次，并不是都执行
		 */
		System.exit(0);// 不能少这句，否则结果会出错
	}
	
}
