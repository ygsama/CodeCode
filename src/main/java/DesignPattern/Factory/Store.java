package DesignPattern.Factory;

/**
 * 
 * @author ygsama
 *
 */
public abstract class Store {
	
//	简单静态工厂
//	SimplePizzaFactory factory;
//	public PizzaStore(SimplePizzaFactory factory) {
//		this.factory = factory;
//	}
	
	// 工厂变化的部分，交给子类覆盖
	abstract Pizza createPizza(String type);
	
	// final 防止子类覆盖
	public final Pizza orderPizza(String type) {
		Pizza pizza ;
		pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
