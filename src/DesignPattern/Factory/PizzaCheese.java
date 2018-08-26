package DesignPattern.Factory;

/**
 * 披萨(Pizza)与原料(Ingredient)解耦
 * @author ygsama
 *
 */
public class PizzaCheese extends Pizza {
	
	IngredientFactory factory;
	
	public PizzaCheese(IngredientFactory factory) {
		this.factory = factory;
	}

	@Override
	void prepare() {
		System.out.println("Preparing " + name );
		dough = factory.createDough();
		sauce = factory.createSauce();
		cheese = factory.createCheese();
	}
}
