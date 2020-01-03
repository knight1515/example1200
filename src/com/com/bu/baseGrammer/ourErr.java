/**
 * @author Administrator
 *
 */
package com.bu.baseGrammer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

import javax.sql.rowset.CachedRowSet;

public class ourErr{
	public static void main(String[] args) {

		setOut1();
	}
	public static void err1(){
		System.out.println("main()方法开始运行了");
		System.err.println("\t该软件没有买保险,请注意安全!");
		System.out.println("main()方法运行结束!");
	}
	
	public static void scanner1(){
		System.out.println("请输入你的身份证号码!");
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		
		System.out.println("你的身份证号码是:"+nextLine+",你的身份证号码是"+nextLine.length()+"位数.");
	}

	public static void setOut1(){

		PrintStream out = System.out;
		String file = "D:/linshi/log.txt";
		try {
			PrintStream ps = new PrintStream(file);
			System.setOut(ps);
			int age = 18;
			System.out.println("年龄变了成功定义,初始化值位18");
			
			Scanner aScanner = new Scanner(System.in);
			System.out.println("你的身份证号码是多少啊?");
			String nek = aScanner.nextLine();
			System.out.println("你输入的身份证号码是:"+nek+",是否正确?");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("你的中文名是什么啊?");
			String nextLine = sc.nextLine();
			System.out.println("哦,你的中文名原来是:"+nextLine+",验证是否正确?");
			
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//强制数据类型转换
	public static void typeConversion(){
		byte b =127;
		char c='W';
		Short s = 23561;
		int i = 3333;
		long l = 400000L;
		float f = 3.14159F;
		double d =54.523;
		System.out.println("累加bype等于:"+b);
		System.out.println("累加char等于:"+(b+c));
		System.out.println("累加short等于"+(b+c+s));
		System.out.println("累加int等于:"+(b+c+s+i));
		System.out.println("累加long等于:"+(b+c+s+i+l));
		System.out.println("累加float等于:"+(b+c+s+i+l+f));
		System.out.println("累加double等于:"+(b+c+s+i+l+f+d));
		System.out.println("把long类型转换为int类型:"+(int)l);
		System.out.println("把int类型转换为short类型:"+(short)i);
		System.out.println("把double类型转换为int类型:"+(int)d);
	}
	private static void yihuo(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你要加密或解密的密码");
		String nextLine = sc.nextLine(); //输入的信息
		char[] charArray = nextLine.toCharArray();
		for(int i=0;i<charArray.length;i++){
			charArray[i]=(char) (charArray[i]^20000);//^异或,不同得一,相同得零
		}
		System.out.println("加密或解密的结果如下");
		System.err.println(new String(charArray));
	}
}