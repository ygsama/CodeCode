package DesignPattern.Decorator;

/**
 * 摩卡
 * @author ygsama
 *
 */
public class Mocha extends CondimentDecorator {
	
	Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + " Mocha";
	}
	
	@Override
	double cost() {
		return 0.80 + beverage.cost();
	}
}
