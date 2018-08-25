package DesignPattern.Decorator;

/**
 * 奶泡
 * @author ygsama
 *
 */
public class Whip extends CondimentDecorator {

	Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + " Whip";
	}
	
	@Override
	double cost() {
		return 0.50 + beverage.cost();
	}

}
