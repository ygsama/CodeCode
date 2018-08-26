package DesignPattern.Factory;

/**
 * 将Pizza与原料对象解耦，不同的原料工厂制造出不同的Pizza
 * @author ygsama
 *
 */
public class StoreChicagoStyle extends Store {

	@Override
	Pizza createPizza(String type) {
		Pizza pizza = null;
		IngredientFactory factory = new IngredientFactoryNY();
		
		if(type.equals("cheese")){
			pizza = new PizzaCheese(factory);
		}else if(type.equals("pepperoni")){
			pizza = new PizzaPepperoni(factory);
		}else if(type.equals("clam")){
			pizza = new PizzaClam(factory);
		}else if(type.equals("veggie")){
			pizza = new PizzaVeggie(factory);
		}
		pizza.name = type;
		return pizza;
	}
}
