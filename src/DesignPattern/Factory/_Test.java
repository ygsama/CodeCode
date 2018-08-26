package DesignPattern.Factory;

/**
 * 简单静态工厂:
 * 		把创建Pizza的操作交给Pizza工厂类完成
 * 		即由SimplePizzaFactory的静态方法createPizza(参数)来创建对象
 * 		缺点，扩展性差，没有接口过于耦合，不适合复杂场景
 * 
 * 工厂方法模式:
 * 		定义了一个创建对象的接口(抽象类)，工厂方法将对象的创建委托给子类。
 * 		即Store抽象类的订单方法为final，但其中会变化的createPizza(参数)是抽象的，交给子类来实现
 * 		缺点，初步解耦，复杂情况下仍需要实现太多的子类
 * 
 * 抽象工厂模式(组合了工厂方法):
 * 		为组合对象，进一步的提供一个接口(抽象类)，用于创建产品相关或依赖对象的家族，而不需要明确指定具体类
 * 		即向Store的子类实现的createPizza(参数)方法中抽象出原料工厂，来解耦多级对象[商店-产品-原料]
 * 		能够进一步的解耦明确的多层级对象关系
 * 
 * 依赖倒置原则:
 * 		要依赖抽象，不要依赖具体类
 * 
 * @author ygsama
 *
 */
public class _Test {

	public static void main(String[] args) {
//		new PizzaStore(new SimplePizzaFactory()).orderPizza("veggie");
		
		StoreNYStyle store = new StoreNYStyle();
		store.orderPizza("cheese");
		
	}
}
