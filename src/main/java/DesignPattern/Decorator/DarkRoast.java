package DesignPattern.Decorator;

/**
 * 深焙咖啡
 * @author ygsama
 *
 */
public class DarkRoast extends Beverage{

	public DarkRoast() {
		description = "DarkRoast";
	}

	@Override
	double cost() {
		return 1.99;
	}
}
