package DesignPattern.Strategy;

public class FlyRocketPowered implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I'm fly with a rocket");
	}
}
