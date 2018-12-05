package com.family.liu.excel;

public class A3_Excelutil {

	public static void main(String[] args) {
		
	}
	
	/**
	 * 导入excel时数字的文本格式，会产生一个小数点
	 * 
	 * 222会得到222.0
	 */
	private static void pointDemo() {
		//获得excel中行的某个列的数据
		HSSFCell cell = row.getCell(j);
		
		////对数据格式化
		cell.setCellType(cell.CELL_TYPE_STRING);
	}
	
	
}
