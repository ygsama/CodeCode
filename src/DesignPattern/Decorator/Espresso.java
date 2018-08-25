package DesignPattern.Decorator;

/**
 * 浓缩咖啡
 * @author ygsama
 *
 */
public class Espresso extends Beverage {

	public Espresso() {
		description = "浓缩咖啡";
	}
	
	
	@Override
	double cost() {
		return 1.99;
	}

}
