package DesignPattern.Singleton;

/**
 * 巧克力工厂的锅炉
 * 		确保只有一个锅炉实例
 * 
 * 
 * @author ygsama
 *
 */
public class ChocolateBoiler {

	private boolean empty;
	private boolean boiled;
	
	public ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	public void fill(){
		if (isEmpty()) {
			empty = false;
			boiled = false;
			// 填满巧克力和牛奶
		}
	}

	public void drain(){
		if(!isEmpty()&&isBoiled()){
			// 倒出沸腾的牛奶巧克力
			empty = true;
		}
	}
	
	public void boil(){
		if(!isEmpty()&&!isBoiled()){
			// 将锅炉煮沸
			boiled = true;
		}
	}
	
	private boolean isEmpty() {
		return empty;
	}
	
	private boolean isBoiled(){
		return boiled;
	}
}
