package DesignPattern.Strategy;

public class _Test {

	public static void main(String[] args) {
		/**
		 * 策略模式：
		 * 		定义一个算法族，分别封装起来，让他们之间可以相互替换，
		 * 		此模式让算法的变化独立于使用算法的业务操作
		 * 		即、把变化的部分取出来封装，通过变量赋值
		 * 		
		 */
		DuckMallar d = new DuckMallar();
		d.display();
		d.performFly();
		d.performQuack();
		
//		 输出：
//	 	I'm MallarDuck
//	 	I can fly With Wings
//	 	呱呱叫
		
		/** 
		 * 通过set动态设置动作
		 */
		DuckModel d2k = new DuckModel();
		d2k.performFly();
		d2k.setFlyBehavior(new FlyRocketPowered());
		d2k.performFly();
		
//		输出：
//	 	I can't fly
//	 	I'm fly with a rocket
	}
}
