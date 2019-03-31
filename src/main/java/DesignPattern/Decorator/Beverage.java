package DesignPattern.Decorator;

/**
 * 饮料抽象类
 * @author ygsama
 *
 */
public abstract class Beverage {

	protected String description;
	
	public String getDescription() {
		return description;
	}
	
	abstract double cost();
	
	
}
