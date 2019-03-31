package DesignPattern.Factory;

public class StoreNYStyle extends Store {

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
