package com.bu.baseGrammer;

public class YanghuiTriangle {
	public static void main(String[] args) {
		yangHui();
	}
	private static void yangHui(){
		int triangle[][] =new int[8][];
		for(int i=0;i<triangle.length;i++){
			triangle[i]=new int[i+1];
			for(int j=0;j<=triangle[i].length-1;j++){
				//将两侧的数组元素赋值为1
				if(i==0||j==0||j==triangle[i].length-1){
					triangle[i][j]=1;
				}else{
					triangle[i][j]=triangle[i-1][j]+triangle[i-1][j-1];
				}
				//输出数组元素
				System.out.print(triangle[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	private static void huiYang(){
		int triangle[][]=new int[8][];
		for(int i=triangle.length;i>0;i--){
			triangle[i]=new int[i+1];
			for(int j=triangle[i].length;j>0;j--){
				if(i==triangle.length||j==triangle[i].length||j==0){
					triangle[i][j]=1;
				}else {
					triangle[i][j]=triangle[i-1][j]+triangle[i-1][j-1];
				}
				//输出数组元素
				System.out.print(triangle[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
