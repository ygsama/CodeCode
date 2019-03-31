package DesignPattern.Strategy;

/**
 * Duck抽象类，将鸭子的动作，委托给行为类
 * @author ygsama
 *
 */
public abstract class Duck {

	QuackBehavior quackBehavior;
	FlyBehavior flyBehavior;
	
	abstract void display();
	
	public void performQuack(){
		quackBehavior.quack();
	}
	public void performFly() {
		flyBehavior.fly();
	}
	
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
}
