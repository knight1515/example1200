package com.bu.baseGrammer;

/**
 * 测试内部类能不能操作一个传入的list
 * @author Administrator
 *
 */
public abstract class NeiBuText {
	public abstract void text(int text);
	
	private void optionText(){
		
		for(int i=0;i<10;i++){
			text(i);
		}
	}
}
