package com.utils.utils_1;

import com.achi.core.model.SystemUser;
import ognl.Ognl;
import ognl.OgnlException;


public class OgnlUtil {
	
	public static Object getAttribute(Object obj, String exp) {
		Object result = null;
		try {
			result = Ognl.getValue(exp, obj);
		} catch (OgnlException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void setAttribute(Object obj, String exp,Object value) {
		try {
			 Ognl.setValue(exp, obj, value);
		} catch (OgnlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SystemUser user = new SystemUser();
		user.setName("test");
		setAttribute(user, "id", 1);
		
		System.out.println("xxxx"
				+ getAttribute(user, "scope.cellid") );
		System.out.println("xxxx"
				+ getAttribute(user, "name") );
		System.out.println("xxxx"
				+ (null instanceof Integer));
	}
}
