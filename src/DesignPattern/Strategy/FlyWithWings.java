package DesignPattern.Strategy;

public class FlyWithWings implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("I can fly With Wings");
	}

}
