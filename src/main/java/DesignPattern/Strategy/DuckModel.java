package DesignPattern.Strategy;

/**
 * 模型鸭子，不会飞
 * 通过动态set，可以让它飞
 * @author ygsama
 *
 */
public class DuckModel extends Duck {
	
	public DuckModel() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new QuackQuack();
	}

	@Override
	void display() {
		System.out.println("I'm a ModelDuck");
	}

}
