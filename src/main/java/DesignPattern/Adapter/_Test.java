package DesignPattern.Adapter;

/**
 * 适配器模式:
 * 		讲一个类的接口，转换成客户期望的另一个接口，适配器让接口不兼容的类完成合作
 * 
 * 		即，客户通过目标接口调用适配器的方法，适配器的方法调用被适配者的一个或多个接口
 * 		客户收到结果，但认为是被适配者返回的结果
 * 
 * @author ygsama
 *
 */
public class _Test {
	
	public static void main(String[] args) {
		MallarDuck duck = new MallarDuck();
		
		WildTurkey turkey = new WildTurkey();
		Duck adapter = new TurkeyAdapter(turkey);
		
		adapter.quack();
		adapter.fly();
		duck.quack();
		duck.fly();
		
	}
}
