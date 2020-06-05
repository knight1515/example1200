package com.utils.utils_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 坐标转换工具
 */
public class CoordinatesUtil {

	//天津90坐标转北京54坐标
	public static List<Double> tj90ToBJ54(double x90,double y90){
		double A=4032271.3232;
		double B=417654.5208;
		double K=0.9999935845;
//		double a=359.87864776500;
		double COSa=0.99999775704719;
		double SINa=-0.0021179944719;
		
		double x54 = A+K*x90*COSa-K*y90*SINa;
		double y54=B+K*y90*COSa+K*x90*SINa;
		
		List<Double> result = new ArrayList<Double>();
		result.add(x54);
		result.add(y54);
		return result;
	}
	
	//北京54坐标和经纬度坐标转换算法c++代码
	//天津 117:10E 39:10N
	public static List<Double> bj54ToJwd(double x, double y)
	{
		double l0=117.10;  //中央子午线的经度
		double bf,vf,nf,ynf,tf,yf2,hbf;
		double sa,sb,se2,sep2,mf;
		double w1,w2,w,w3,w4;
		double pi = 3.1415926;
		double l,b; //转换后坐标
	
		x = x/1000000.0;
		y = y - 500000.0;
	
		bf = 9.04353692458*x-0.00001007623*Math.pow(x,2.0)-0.00074438304*Math.pow(x,3.0)-0.00000463064*Math.pow(x,4.0)+0.00000505846*Math.pow(x,5.0)-0.00000016754*Math.pow(x,6.0);
		hbf = bf * pi/ 180.0;
		sa = 6378245.0;
		sb = 6356863.019;
		se2 = 0.006693421623;
		sep2 = 0.006738525415;
	
		w1 = Math.sin(hbf);
		w2 = 1.0 - se2 * Math.pow(w1,(double)2);
		w = Math.sqrt(w2);
		mf = sa*(1.0-se2)/Math.pow(w,(double)3);
		w3 = Math.cos(hbf);
	
		w4 = Math.pow(sa,(double)2)*Math.pow(w3,(double)2) + Math.pow(sb,(double)2)*Math.pow(w1,(double)2);
		nf = Math.pow(sa,(double)2) / Math.sqrt(w4);
	
		ynf = y/nf;
		vf = nf/mf;
		tf = Math.tan(hbf);
	
		yf2 = sep2 * Math.pow(w3, (double)2);
	
		b = bf - 1.0/2.0 * vf * tf * (Math.pow(ynf,(double)2)-1.0/12.0*(5.0+3.0*Math.pow(tf,(double)2)+yf2-9.0*yf2*Math.pow(tf,(double)2))*Math.pow(ynf,(double)4))*180.0/pi;
		l = 1.0/w3*ynf*(1.0-1.0/6.0*(1.0+2.0*Math.pow(tf,(double)2)+yf2)*Math.pow(ynf,(double)2)+1.0/120.0*(5.0+28.0*Math.pow(tf,(double)2)+24.0*Math.pow(tf,(double)2)+6.0*yf2+8.0*yf2*Math.pow(tf,(double)2))*Math.pow(ynf,(double)4))*180.0/pi;
		l = l0 + l;
		
		List<Double> result = new ArrayList<Double>();
		result.add(l);
		result.add(b);
		return result;
	}
	
	public static void main(String[] args) {
		List a  = CoordinatesUtil.tj90ToBJ54(536770.66, 4333346.505);
		System.out.println(a.get(0) + "," + a.get(1));
	}
	
}
