package DesignPattern.Factory;

/**
 * 生产披萨原料的工厂接口
 * @author ygsama
 *
 */
public interface IngredientFactory {

	// 创建原料的方法
	Dough createDough();
	Sauce createSauce();
	Cheese createCheese();
	Veggies[] createVeggies();
	Pepperoni createPepperoni();
	Clams createClams();
}
