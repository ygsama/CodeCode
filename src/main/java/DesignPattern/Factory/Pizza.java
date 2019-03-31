package DesignPattern.Factory;

import java.util.ArrayList;

/**
 * 披萨抽象类
 * @author ygsama
 *
 */
public abstract class Pizza {

	String name;
	Dough dough;// 面团类型
	Sauce sauce;// 酱料类型
	Cheese cheese;
	Clams clams;// 蛤蜊
	ArrayList<String> toppings = new ArrayList<String>();// 一套佐料
	
	/**
	 * 抽象方法prepare()需要收集来自原料工厂(IngredientFactory)的的原料
	 */
	abstract void prepare();
	
	void bake(){
		System.out.println("Bake for 25 minutes at 350");
	};
	void cut(){
		System.out.println("Cutting the pizza into diagonal slices");
	};
	void box(){
		System.out.println("Place pizza in official PizzaStore box");
	};
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		// 打印披萨
		return super.toString();
	}
}
