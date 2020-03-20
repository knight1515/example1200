package com.bu.baseGrammer;

import java.util.ArrayList;
import java.util.List;

/**
 * 匿名内部类可以操作外部的变量
 * @author Administrator
 *
 */
public class EbankText {
	static List list = new ArrayList();
	public void textNeiBu(){
		
		NeiBuText neiBuText=new NeiBuText() {
			@Override
			public void text(int text) {
				list.add(text);
			}
		};
		System.out.println(list.toString());
	}
	public static void main(String[] args) {
		NeiBuText neiBuText=new NeiBuText() {
			@Override
			public void text(int text) {
				System.out.println("里面");
				list.add(text);
				System.out.println(list.toString());
			}
			
		};
		neiBuText.text(23);
		System.out.println("外面："+list.toString());
	}
}
