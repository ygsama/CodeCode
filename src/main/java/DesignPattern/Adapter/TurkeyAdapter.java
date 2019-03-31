package DesignPattern.Adapter;

/**
 * 适配器: 
 * 		用鸭子冒充火鸡
 * @author ygsama
 *
 */
public class TurkeyAdapter implements Duck {

	Turkey turkey;
	
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
	
	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		turkey.fly();
	}

}
