package DesignPattern.Decorator;

/**
 * 豆浆
 * @author ygsama
 *
 */
public class Soy extends CondimentDecorator {

	Beverage beverage;
		
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + " Soy";
	}
	
	@Override
	double cost() {
		return 0.70 + beverage.cost();
	}

}
