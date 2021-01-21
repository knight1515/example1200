package com.bu.baseGrammer;
/**
 * break可以跳出当前循环，并不在执行
 * break 后面制定No1可以跳的No1指定的位置，并不在执行。
 * @author Administrator
 * 增加个注释
 * 这样就不能切换了
 */
public class BreakCye {
	public static void main(String[] args) {
		ceshiBreak();
	}
	
	private static void ceshiBreak(){
		String[] array=new String[]{
			"fds","df","hd","老鹰"
		};
		
		System.out.println("出现老鹰前都有什么东东");
		for(String string: array){
			if(string.equals("老鹰")){
				break;
			}
			System.out.println(string);
		}
		
		System.out.println("\n\n-----------中断双层循环的例子-------");
		int[][] myScores=new int[][]{
			{34,53,2,5,4},{34,65,54,77,89},{86,75,45,67,88}
		};
		No1:for (int[] s:myScores) {
			for(int a:s){
				System.out.print(a+"\t");
				if (a<60) {
					System.out.println("\n 等等，"+a+"分的是什么？这个为啥不及格");
					break No1;
				}
			}
		}
	}
}
