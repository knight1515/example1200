package com.family.liu.excel;

/**
 * 在内部资金应用的。
 * EbankCertificateOperate中的
 * @author hp
 *
 */
public class A2_ExcelImport_X {
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 原action中方法
	 */
	private static void impdata() {
		ToftLogger.info("==========执行==========");
		try {
			HttpServletRequest request = super.getRequest();
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = upload.parseRequest(request);
			List<String[]> datalist = null;
			for (FileItem fileItem : items) {
				if(!fileItem.isFormField()){
					datalist = convertList(fileItem.getInputStream());
				}
			}
			this.getContext().addAttribute("datalist", datalist);
			this.callServiceProxy("EbankCertificateOperate","impdata");
			this.getRequest().setAttribute("success", this.getContext().getAttribute("success"));
			this.getRequest().setAttribute("message", this.getContext().getAttribute("message"));
		} catch (Exception e) {
			throw ToftException.ThrowToftException("导入失败:"+e.getMessage());
		}
		return SUCCESS;
	}
	

	
	////////////////////////一下都是excel的
	/**
	 * 转换Excel, 第一行为 title
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static List<String[]> convert2List(InputStream in) throws IOException {
		List<String[]> list = new ArrayList<String[]>();
		//得到工作表
		HSSFWorkbook book = new HSSFWorkbook(new POIFSFileSystem(in));
		//得到第一页
		HSSFSheet sheet = book.getSheetAt(0);
		//得到第一页的所有行
//		int rows = sheet.getPhysicalNumberOfRows();
		int rows = sheet.getLastRowNum() + 1;
		HSSFRow row = sheet.getRow(0);
//		int cols = row.getPhysicalNumberOfCells();
		int cols = row.getLastCellNum() + 1;
		
		for (int i = 1; i <= rows; i++) {
			String [] line = new String[cols];
			for (int j = 0; j<cols; j++) {
				line[j] = getCellvalue(row.getCell(j));
			}
			list.add(line);
			//
			row = sheet.getRow(i);
		}
		return list;
	}
	
	/**
	 * 转换Excel, 第一行为 title
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static List<String[]> convertList(InputStream in) throws IOException {
		List<String[]> list = new ArrayList<String[]>();
		//得到工作表
		HSSFWorkbook book = new HSSFWorkbook(new POIFSFileSystem(in));
		//得到第一页
		HSSFSheet sheet = book.getSheetAt(0);
		//得到第一页的所有行
		int rows = sheet.getLastRowNum() + 1;
		HSSFRow row = sheet.getRow(0);
		int cols = row.getLastCellNum() + 1;
		//ToftLogger.debug("$$$$$$$$$$一共："+rows+"行");
		for (int i = 1; i <= rows; i++) {
			if(null==row){
				continue ;
			}
			String [] line = new String[cols];
			for (int j = 0; j<cols; j++) {
				HSSFCell cell = row.getCell(j);
				if(j==0||j==2||j==3){
					cell.setCellType(cell.CELL_TYPE_STRING);
				}
				line[j] = getCellvalue2(cell);
			}
			list.add(line);
			
			row = sheet.getRow(i);
		}
		return list;
	}
	
	/**
	 * @param sheet
	 * @param r
	 * @param c
	 * @return
	 */
	public static HSSFCell findCell(HSSFSheet sheet, int r, int c) {
		try {
			return sheet.getRow(r).getCell(c);
		} catch (Exception e) {
			System.out.println(e.getMessage()+"； 行："+r+", 列："+c);
		}
		return null;
	}
	
	/**
	 * 取cell中值
	 * @return string
	 */
	public static String getCellvalue(HSSFCell cell) {
		if(cell==null){
			return "";
		}
		String cellValue = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:
			cellValue = cell.getRichStringCellValue().getString().trim();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			cellValue = BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cellValue = BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			cellValue = "";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			break;
		default:
			break;
		}
		return cellValue.trim();
	}
	
	/**
	 * 取cell中值
	 * @return string
	 */
	public static String getCellvalue2(HSSFCell cell) {
		if(cell==null){
			return "";
		}
		String cellValue = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:
			cellValue = cell.getRichStringCellValue().getString().trim();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			if(HSSFDateUtil.isCellDateFormatted(cell)){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				cellValue = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
			} else{
				cellValue = BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
			}
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cellValue = BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			cellValue = "";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			break;
		default:
			break;
		}
		return cellValue.trim();
	}
	
	/**
	 * 取cell中值
	 * @return string
	 */
	public static String getCellStringValue(HSSFCell cell) {
		if(cell==null){
			return "";
		}
		try {
			return cell.getRichStringCellValue().getString().trim();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 取cell中值
	 * @return long
	 */
	public static long getCellLongValue(HSSFCell cell) {
		if(cell==null){
			return 0l;
		}
		try {
			String str = getCellvalue(cell);
			return new Double(str).longValue();
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	/**
	 * 取cell中值
	 * @return int
	 */
	public static int getCellIntValue(HSSFCell cell) {
		if(cell==null){
			return 0;
		}
		try {
			String str = getCellvalue(cell);
			return new Double(str).intValue();
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	/**
	 * 取cell中值
	 * @return string
	 */
	public static float getCellFloatValue(HSSFCell cell) {
		if(cell==null){
			return 0;
		}
		try {
			String str = getCellvalue(cell);
			return new Double(str).floatValue();
		} catch (NumberFormatException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	/**
	 * Money
	 * @param cell
	 * @return
	 */
	public static double getCellMoneyValue(HSSFCell cell) {
		if(cell==null){
			return 0;
		}
		try {
			String str = getCellvalue(cell);
			if(!"".equals(str))
				return new Double(str.replace(",", "")).doubleValue();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public static void setCellType(HSSFCell cell,Class clazzType){
		if(clazzType.equals(Byte.TYPE)
				||clazzType.equals(Short.TYPE)
				||clazzType.equals(Integer.TYPE)
				||clazzType.equals(Long.TYPE)
				||clazzType.equals(Float.TYPE)
				||clazzType.equals(Double.TYPE)
//				||clazzType.equals(Boolean.TYPE)
//				||clazzType.equals(String.class)
//				||clazzType.equals(Date.class)
		){
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		}
		else{
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		}
	}
	
	/**
	 * 导出Excel
	 * @param data List VO list 
	 * @param map  Map key=fieldName, value=columnName
	 * @return
	 * @throws Exception
	 */
	public static byte[] exportToExcel(Collection data, Map headMap) throws Exception {
		String[] fields = (String[]) headMap.keySet().toArray(new String[] {});
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		HSSFCellStyle cellStyle1 = wb.createCellStyle();
		cellStyle1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle1.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
//		cellStyle1.setBorderBottom(HSSFColor.GREY_25_PERCENT.index);
//		cellStyle1.setBorderRight(HSSFColor.GREY_25_PERCENT.index);
//		cellStyle1.setBorderLeft(HSSFColor.GREY_25_PERCENT.index);
//		cellStyle1.setBorderTop(HSSFColor.GREY_25_PERCENT.index);
		cellStyle1.setWrapText(false);//
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 14); // 字体高度
		font.setColor(HSSFColor.BLACK.index); // 字体颜色
		font.setFontName("宋体"); // 字体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
		font.setItalic(false); // 是否使用斜体
		HSSFFont font1 = wb.createFont();
		font1.setFontHeightInPoints((short) 10); // 字体高度
		font1.setColor(HSSFColor.BLUE.index); // 字体颜色
		font1.setFontName("Arial"); // 字体
		font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
		font1.setItalic(true); // 是否使用斜体
		
		//表头
		HSSFRow rowhead = sheet.createRow(0);
		HSSFCell cell = rowhead.createCell((short)0);
		for (int j = 0; j < headMap.size(); j++) {
			cell = rowhead.createCell((short) j);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			HSSFRichTextString rstr = new HSSFRichTextString(headMap.get(fields[j]).toString());
			cell.setCellValue(rstr);
//			cell.setCellStyle(cellStyle1);
			sheet.autoSizeColumn((short)j);
			sheet.setColumnWidth((short)j, (short)(35.7*160));
		}
		Iterator iter = data.iterator();
		//内容
		for (int i = 1;iter.hasNext();i++) {
			Object obj = iter.next();
			HSSFRow row = sheet.createRow(i);
			for (int j = 0; j < headMap.size(); j++) {
				cell = row.createCell((short) j);
				HSSFRichTextString rstr = null;
				
				Object objvalue;
				if (obj instanceof Map) {
					objvalue = ((Map)obj).get(fields[j]);
				} else {
					String methodName = "get" + fields[j].substring(0, 1).toUpperCase() + fields[j].substring(1);
					Method m = obj.getClass().getMethod(methodName, new Class[] {});
					objvalue = m.invoke(obj, new Object[] {});
				}

				if(objvalue!=null){
					rstr = new HSSFRichTextString(objvalue.toString());
					ExcelUtils.setCellType(cell, objvalue.getClass());
				}else{
					rstr = new HSSFRichTextString("");
				}
				cell.setCellValue(rstr);
			}
		}
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		wb.write(out);
		byte [] 
		rs = out.toByteArray();
		return rs;
//		return wb.getBytes();
	}
	
	public static HSSFWorkbook convert2Excel(List<String[]> data) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		HSSFCellStyle cellStyle1 = wb.createCellStyle();
		cellStyle1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle1.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		cellStyle1.setWrapText(false);//
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 14); // 字体高度
		font.setColor(HSSFColor.BLACK.index); // 字体颜色
		font.setFontName("宋体"); // 字体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
		font.setItalic(false); // 是否使用斜体
		HSSFFont font1 = wb.createFont();
		font1.setFontHeightInPoints((short) 10); // 字体高度
		font1.setColor(HSSFColor.BLUE.index); // 字体颜色
		font1.setFontName("Arial"); // 字体
		font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
		font1.setItalic(true); // 是否使用斜体
		
		HSSFRow rowhead = sheet.createRow(0);
		HSSFCell cell = rowhead.createCell((short)0);
		//内容
		for (int i = 0; i<data.size(); i++) {
			String [] strs = data.get(i);
			HSSFRow row = sheet.createRow(i);
			for (int j = 0; j < strs.length; j++) {
				cell = row.createCell((short) j);
				//ExcelUtils.setCellType(cell, String.class);
				HSSFRichTextString rstr = null;
				if(strs[j]!=null){
					rstr = new HSSFRichTextString(strs[j]);
				}else{
					rstr = new HSSFRichTextString("");
				}
				cell.setCellValue(rstr);
			}
		}
		
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		wb.write(out);
//		byte [] 
//		rs = out.toByteArray();
//		return rs;
		return wb;
	}
}
