package com.bu.baseGrammer;

import java.util.ArrayList;
import java.util.List;
/**
 * forEach应用
 * @author Administrator
 *
 */
public class UserForeach {
	
	public static void main(String[] args) {
		textForeach();
	}
	
	private static void textForeach(){
		List<String> list=new ArrayList<String>();
		list.add("kjd");
		list.add("adf");
		list.add("dsfebhj");
		list.add("dkj");
		list.add("jicn");
		list.add("kjjd");
		list.add("vvfe");
		list.add("kjd");
		
		for(String a:list){
			System.out.println(a);
		}
		
		String[] str = new String[list.size()];
		list.toArray(str);
		System.out.println("foreach 遍历数组： \n\t");
		for(String strr:str){
			System.out.println(strr);
		}
	}
	
}
