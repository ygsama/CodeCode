package DesignPattern.TemplateMethod;

public class Coffee extends CaffeineBeverage implements Comparable {
	public void brew() {
		System.out.println("Dripping Coffee through filter");
	}
	public void addCondiments() {
		System.out.println("Adding Sugar and Milk");
	}
	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
