package DesignPattern.TemplateMethod;

import java.util.Arrays;

/**
 * 模板方法模式:
 * 		定义了一个算法的骨架步骤，将一些步骤延迟到子类中实现。
 * 		使子类在不改变算法结构的情况下，重新定义算法中某些步骤
 * 		如Arrays.sort，传入一个实现Comparable接口的对象列表时会调用对象自己的比较算法
 * @author ygsama
 *
 */
public class _Test {

	public static void main(String[] args) {
		Arrays.sort(new int[]{1,2,3});
		Arrays.sort(new Coffee[]{});
		
		Tea tea = new Tea();
		Coffee coffee = new Coffee();
 
		System.out.println("\nMaking tea...");
		tea.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();

 
		TeaWithHook teaHook = new TeaWithHook();
		CoffeeWithHook coffeeHook = new CoffeeWithHook();
 
		System.out.println("\nMaking tea...");
		teaHook.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffeeHook.prepareRecipe();
	}
}
