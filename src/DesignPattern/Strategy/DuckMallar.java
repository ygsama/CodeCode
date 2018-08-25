package DesignPattern.Strategy;

public class DuckMallar extends Duck{

	public DuckMallar() {
		quackBehavior = new QuackQuack();
		flyBehavior = new FlyWithWings();
	}
	
	void display(){
		System.out.println("I'm MallarDuck");
	}
	
	@Override
	public void performFly() {
		flyBehavior.fly();
	}
	
	@Override
	public void performQuack() {
		quackBehavior.quack();
	}
	
}
