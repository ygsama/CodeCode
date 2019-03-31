package DesignPattern.Factory;

public class PizzaPepperoni extends Pizza {

	IngredientFactory factory;
	
	public PizzaPepperoni(IngredientFactory factory) {
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
