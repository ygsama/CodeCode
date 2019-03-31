package DesignPattern.Factory;

/**
 * 原料工厂实现类
 * @author ygsama
 *
 */
public class IngredientFactoryNY implements IngredientFactory {

	@Override
	public Dough createDough() {
		return new DoughThinCrust();
	}

	@Override
	public Sauce createSauce() {
		return new SauceMarinara();
	}

	@Override
	public Cheese createCheese() {
		return new CheeseReggiano();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies[] v = {new VeggiesOnion(),new VeggiesGarlic(),
				new VeggiesMushroom(),new VeggiesRedPepper()};
		return v;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new PepperoniSliced();
	}

	@Override
	public Clams createClams() {
		return new ClamsFresh();
	}

}
