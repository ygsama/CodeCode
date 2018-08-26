package DesignPattern.Factory;

public class PizzaClam extends Pizza {

	IngredientFactory factory;
	
	public PizzaClam(IngredientFactory factory) {
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
