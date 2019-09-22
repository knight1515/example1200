package com.desinpattern.proxy;
/**
 * 静态代理模式。
 * 
 * 测试类本来是先做委托类BuyHouseImpl的事情,
 * 
 * 但是做委托类的事情,需要其他必要的事情
 * 这个必要的事情要么自己做,要么让一个中间人做
 * 
 * 这里是让代理类BuyHouseProxy做的.
 * @author: gzb
 * @date  : 2019年9月22日 下午3:21:44
 *
 */

/**
 * 测试类
 * 
 * @author: gzb
 * @date  : 2019年9月22日 下午3:43:22
 *
 */
public class AStaticProxyTest {
	public static void main(String[] args) {
		BuyHouse buyHouse = new BuyHouseImpl();
		
		buyHouse.buyHouse();
		
		BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHouse);
		
		buyHouseProxy.buyHouse();
	}
}


/**
 * 代理类和委托类都实现这个接口，代理类实现实际要做的事，委托类在实际要做的事中，做些其他必要的事情
 * 例如：这里代理类实现买房子，委托类在不单实现买房，也在完成买房前的准备工作和买房后的补充工作。
 * 
 * @author: gzb
 * @date  : 2019年9月22日 下午3:43:28
 *
 */
interface BuyHouse {
	void buyHouse();
}

//实际要完成的事情，委托类
class BuyHouseImpl implements BuyHouse{

	@Override
	public void buyHouse() {
		System.out.println("我要买房;");
	}
}

//代理类，在委托类基础上做点其他必要的事情
class BuyHouseProxy implements BuyHouse{
	private BuyHouse buyHouse;
	
	public BuyHouseProxy(BuyHouse buyHouse) {
		this.buyHouse = buyHouse;
	}
	
	@Override
	public void buyHouse() {
		System.out.println("买房前准备；");
		buyHouse.buyHouse();
		System.out.println("买房后的事情；");
	}
}

