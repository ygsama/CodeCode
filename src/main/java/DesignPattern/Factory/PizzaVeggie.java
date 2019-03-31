package DesignPattern.Factory;

public class PizzaVeggie extends Pizza {

	IngredientFactory factory;
	
	public PizzaVeggie(IngredientFactory factory) {
		this.factory = factory;
	}

	@Override
	void prepare() {
		System.out.println("Preparing " + name );
		dough = factory.createDough();
		sauce = factory.createSauce();
		cheese = factory.createCheese();
		clams = factory.createClams();
	}
}
