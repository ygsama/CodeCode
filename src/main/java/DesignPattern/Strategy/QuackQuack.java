package DesignPattern.Strategy;

public class QuackQuack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("呱呱叫");
	}
}
