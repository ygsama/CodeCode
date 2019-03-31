package DesignPattern.Decorator;

/**
 * 遵循  "对扩展开放，对修改关闭" 原则
 * 
 * 装饰者模式:
 * 		动态的将责任附加到对象上，若要扩展功能，装饰者提供了比继承更有弹性的替代方案
 * 		Java的IO类就是一个典型的装饰者模式
 * 
 * 缺点: 	设计中存在大量的小类，数量太多也会造成程序员的困扰
 * 		实例化时很麻烦
 * 
 * @author ygsama
 *
 */
public class _Test {
	
	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());
		
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
		
		Beverage beverage3 = new DarkRoast();
		beverage3 = new Mocha(beverage3);
		beverage3 = new Soy(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
		
		
		
	}
	
}
