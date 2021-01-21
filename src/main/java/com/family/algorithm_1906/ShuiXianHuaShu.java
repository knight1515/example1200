package com.family.algorithm_1906;

import java.util.ArrayList;
import java.util.List;

public class ShuiXianHuaShu {
	public static void main(String[] args) {
		List shuiList = getShuiList2();
		System.out.println("公有水仙花个数："+shuiList.size());
		for(Object shuiXianHua:shuiList) {
			System.out.println(shuiXianHua);
		}
	}
	/**
	 * 方法一
	 * @return
	 */
	private static List getShuiList() {
		List shuiList=new ArrayList();
		for(int a=0;a<10;a++) {
			int aa=a*a*a;
			for(int b=0;b<10;b++) {
				int bb=b*b*b;
				for(int c=0;c<10;c++) {
					int cc=c*c*c;
					StringBuffer shuiXianHua=new StringBuffer();
					String shuiXianHuaShuString = shuiXianHua.append(a).append(b).append(c).toString();
					Integer shuiXianHuaShu =Integer.parseInt(shuiXianHuaShuString);
					if ((aa+bb+cc)==shuiXianHuaShu&&shuiXianHuaShu>100) {
						shuiList.add(shuiXianHuaShu);
					}
				}
			}
		}
		return shuiList;
	}
	/**
	 * 方法二
	 * @return
	 */
	private static List getShuiList2() {
		List shuiList=new ArrayList();
		for(int i=100;i<1000;i++) {
			int ge=i%10;
			int shi=i%100/10;
			int bai=i/100;
			if((ge*ge*ge+shi*shi*shi+bai*bai*bai)==i) {
				shuiList.add(i);
			}
		}
		return shuiList;
	}
}
