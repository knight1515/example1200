package com.utils.utils_1;

import org.springframework.util.StringUtils;

public class LatLonUtil {
	
	static double pi = 3.14159265358979324;
	static double a = 6378245.0;
	static double ee = 0.00669342162296594323;
	public final static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;

	public static double[] wgs2bd(double lat, double lon) {
	       double[] wgs2gcj = wgs2gcj(lat, lon);
	       double[] gcj2bd = gcj2bd(wgs2gcj[0], wgs2gcj[1]);
	       return gcj2bd;
	}

	public static double[] gcj2bd(double lat, double lon) {
	       double x = lon, y = lat;
	       double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
	       double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
	       double bd_lon = z * Math.cos(theta) + 0.0065;
	       double bd_lat = z * Math.sin(theta) + 0.006;
	       return new double[] { bd_lat, bd_lon };
	}

	public static double[] bd2gcj(double lat, double lon) {
	       double x = lon - 0.0065, y = lat - 0.006;
	       double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
	       double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
	       double gg_lon = z * Math.cos(theta);
	       double gg_lat = z * Math.sin(theta);
	       return new double[] { gg_lat, gg_lon };
	}

	public static double[] wgs2gcj(double lat, double lon) {
	       double dLat = transformLat(lon - 105.0, lat - 35.0);
	       double dLon = transformLon(lon - 105.0, lat - 35.0);
	       double radLat = lat / 180.0 * pi;
	       double magic = Math.sin(radLat);
	       magic = 1 - ee * magic * magic;
	       double sqrtMagic = Math.sqrt(magic);
	       dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
	       dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
	       double mgLat = lat + dLat;
	       double mgLon = lon + dLon;
	       double[] loc = { mgLat, mgLon };
	       return loc;
	}

	private static double transformLat(double lat, double lon) {
	       double ret = -100.0 + 2.0 * lat + 3.0 * lon + 0.2 * lon * lon + 0.1 * lat * lon + 0.2 * Math.sqrt(Math.abs(lat));
	       ret += (20.0 * Math.sin(6.0 * lat * pi) + 20.0 * Math.sin(2.0 * lat * pi)) * 2.0 / 3.0;
	       ret += (20.0 * Math.sin(lon * pi) + 40.0 * Math.sin(lon / 3.0 * pi)) * 2.0 / 3.0;
	       ret += (160.0 * Math.sin(lon / 12.0 * pi) + 320 * Math.sin(lon * pi  / 30.0)) * 2.0 / 3.0;
	       return ret;
	}

	private static double transformLon(double lat, double lon) {
	       double ret = 300.0 + lat + 2.0 * lon + 0.1 * lat * lat + 0.1 * lat * lon + 0.1 * Math.sqrt(Math.abs(lat));
	       ret += (20.0 * Math.sin(6.0 * lat * pi) + 20.0 * Math.sin(2.0 * lat * pi)) * 2.0 / 3.0;
	       ret += (20.0 * Math.sin(lat * pi) + 40.0 * Math.sin(lat / 3.0 * pi)) * 2.0 / 3.0;
	       ret += (150.0 * Math.sin(lat / 12.0 * pi) + 300.0 * Math.sin(lat / 30.0 * pi)) * 2.0 / 3.0;
	       return ret;
	}
	
	public static String convertGPSToBaidu(String LngLats) {
	    //http://api.map.baidu.com/ag/coord/convert?from=0&to=4&x=120.27031&y=30.191022
		if(StringUtils.isEmpty(LngLats)){
			return null;
		}
//		BASE64Decoder decoder = new BASE64Decoder();
		String [] LngLatsArray = LngLats.split(";");
		String lls = "";
		for(int i = 0;i<LngLatsArray.length;i++){
			
			if(StringUtils.isEmpty(LngLatsArray[i])){
				 continue;
			}
			String ll = "";
			String[] latLngArray = LngLatsArray[i].split(",");
			
			double[] latLon = LatLonUtil.wgs2bd(Double.parseDouble(latLngArray[1]), Double.parseDouble(latLngArray[0]));
			
			 ll= Double.toString(latLon[0]);
             ll = ll + ",";
             ll = ll + Double.toString(latLon[1]);
             lls = lls + ll;
             if(i+1<LngLatsArray.length){
             	lls = lls + ";";
             }
			
//			String urlNameString = "http://api.map.baidu.com/ag/coord/convert?from=0&to=4&x=" + latLngArray[0] + "&y=" + latLngArray[1];
//			try {
//	            // 根据地址获取请求
//	            HttpGet request = new HttpGet(urlNameString);//这里发送get请求
//	            // 获取当前客户端对象
//	            HttpClient httpClient = new DefaultHttpClient();
//	            // 通过请求对象获取响应对象
//	            HttpResponse response = httpClient.execute(request);
//	            
//	            // 判断网络连接状态码是否正常(0--200都数正常)
//	            if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
//	                String result= EntityUtils.toString(response.getEntity(),"utf-8");
//	                JSONObject jo = (JSONObject) JSON.parseObject(result);
//	                String LatSource = jo.getString("x");
//	                String LngSource = jo.getString("y");
//	                ll= new String(decoder.decodeBuffer(LngSource));
//	                ll = ll + ",";
//	                ll = ll + new String(decoder.decodeBuffer(LatSource));
//	                lls = lls + ll;
//	                if(i+1<latLngsArray.length){
//	                	lls = lls + ";";
//	                }
//	            } 
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
			
		}
		return lls;
			
	}
	
	public static void main(String[] args) {
		System.out.println(LatLonUtil.convertGPSToBaidu("118.351441, 29.194759"));
	}

}
