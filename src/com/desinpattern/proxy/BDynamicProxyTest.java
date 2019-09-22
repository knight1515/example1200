package com.desinpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BDynamicProxyTest {
	public static void main(String[] args) {
		BuyHouse buyHouse = new BuyHouseImpl();
		/**
		 * ClassLoader loader:指定当前目标对象使用的类加载器,获取加载器的方法是固定的
		 * Class<?>[] interfaces:指定目标对象实现的接口的类型,使用泛型方式确认类型
		 * InvocationHandler:指定动态处理器，执行目标对象的方法时,会触发事件处理器的方法
		 */
		BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),
				new Class[] { BuyHouse.class }, new DynamicProxyHandler(buyHouse));
		proxyBuyHouse.buyHouse();
	}
}

/**
 * 动态的代理类，一次代理类，多个委托类可用
 * 
 * @author: gzb
 * @date  : 2019年9月22日 下午5:35:34
 *
 */
class DynamicProxyHandler implements InvocationHandler {
	private Object object;

	public DynamicProxyHandler(final Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("买房前准备；");
		Object result = method.invoke(object, args);
		System.out.println("买房后装修");
		return result;
	}
}
