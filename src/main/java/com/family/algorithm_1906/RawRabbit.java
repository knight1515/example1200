package com.family.algorithm_1906;

/**
 * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第3个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765
 * 
 * @author hp
 *
 */
public class RawRabbit {

	public static void main(String args[]) {
		// for(int i=1;i<=20;i++) {
		// System.out.print(iteratorAlgorithm(i)+",");
		// }
		
		math myMath=new math();
		for(int i=1;i<=20;i++) {
			System.out.println(myMath.iteratorAlgorithm(i));
		}
	}

	/**
	 * 思想：1、本月有多少兔子可以生兔子，因为第三个月的兔子都会生，可以理解为上上个月的兔子都会生，（如本月是34月，32月数量的兔子会生），
	 * 2、本月的兔子是上个月的兔子数量，加上生出来的兔子 迭代：求6月的，先求5、4月份的，以此类推获得兔子数量。
	 * @param args
	 */
	public static int iteratorAlgorithm(int monthData) {
		if (monthData == 1 || monthData == 2) {
			return 1;
		} else {
			int sum = iteratorAlgorithm(monthData - 1) + iteratorAlgorithm(monthData - 2);
			return sum;
		}
	}
}

class math{
	public int iteratorAlgorithm(int monthData) {
		if (monthData==1||monthData==2) {
			return 1;
		}else {
			return iteratorAlgorithm(monthData-1)+iteratorAlgorithm(monthData-2);
		}
	}
}

