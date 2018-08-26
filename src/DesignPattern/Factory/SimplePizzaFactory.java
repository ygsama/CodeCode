package DesignPattern.Factory;

/**
 * 披萨工厂类——简单工厂模式
 * @author ygsama
 *
 */
public class SimplePizzaFactory {

	public static Pizza createPizza(String type){
		Pizza pizza = null;
//		if(type.equals("cheese")){
//			pizza = new PizzaCheese();
//		}else if(type.equals("pepperoni")){
//			pizza = new PizzaPepperoni();
//		}else if(type.equals("clam")){
//			pizza = new PizzaClam();
//		}else if(type.equals("veggie")){
//			pizza = new PizzaVeggie();
//		}
		return pizza;
	}
}
