package DesignPattern.Decorator;

public class HouseBlend extends Beverage {

	
	public HouseBlend() {
		description = "House Blend Coffee";
	}
	
	@Override
	double cost() {
		return 0.89;
	}

}
