package com.bu.baseGrammer;

public class CycFilter {
	public static void main(String[] args) {
		CycText();
	}
	
	/**
	 * 抓老鹰，不抓其他的鸟
	 */
	private static void CycText(){
		String[] array=new String[]{
			"千里目","老鹰","千里目","老鹰","千里目","老鹰","千里目","老鹰"
		};
		
		int engleCnt=0;
		for(String string:array){
			if ("老鹰".equals(string)) {
				System.out.println("发现一只老鹰，抓进笼子里啦！");
				engleCnt++;
				continue;
			}
		}
		System.out.println("搜索完毕，发现了："+engleCnt+"只老鹰！");
	}
}
