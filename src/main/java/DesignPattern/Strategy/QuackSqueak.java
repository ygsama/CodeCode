package DesignPattern.Strategy;

public class QuackSqueak implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("吱吱叫");
	}
}
