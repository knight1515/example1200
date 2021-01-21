package com.family.algorithm_1906;

import java.sql.Time;
import java.util.Arrays;

/**
 * 判断101-200之间有多少个素数，并输出所有素数;
 * 素数定义：只能被1和本身整除，没有其他任何因数，又称为质数；
 * 
 * 
 * @author hp
 *
 */
public class PrimeNumber {
	public static void main(String args[]) {
		System.err.println(1);
		if (testIsPrime2(17)) {
			System.out.println("2是素数！");
		}
		System.out.println("1不是素数！");
		System.out.println(2);
	}
	
	/**
	 * 算法1
	 * @param n
	 * @return
	 */
	public static boolean testIsPrime(int n) {
		if(n<=1) {
			return n>1;
		}
		for (int i = 2; i < n; i++) {
			if (n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 算法2
	 * @param n
	 * @return
	 */
	public static boolean testIsPrime2(int n) {
		if (n<=3) {
			return n>1;
		}
		for(int i=2;i<=Math.sqrt(n); i++) {
			if (n%i==0) {
				return false;
			}
		}
		return true;
	}
	
}

/**
 * 自己做的，看了人家的，算法不会累死人啊！
 * @author hp
 *
 */
class math2 {
	/**
	 * @param x
	 * @return
	 */
	public boolean iszhishu(int naturalNumber) {
		Integer[] minZhiShu= {2,3,5,7};
		Boolean isOrZhiShu=false;
		if (naturalNumber<=1) {
			return isOrZhiShu;
		}
		else if (Arrays.asList(minZhiShu).contains(naturalNumber)) {
			isOrZhiShu=true;
		}
		else {
			for(int i=0;i<minZhiShu.length;i++) {
				if (naturalNumber%minZhiShu[i]!=0) {
					isOrZhiShu=true;
				}
				else {
					isOrZhiShu=false;
					break;
				}
			}
		}
		return isOrZhiShu;
	}

}
