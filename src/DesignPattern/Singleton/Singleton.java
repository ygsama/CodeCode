package DesignPattern.Singleton;

/**
 * 懒汉单例，线程不安全
 * @author ygsama
 *
 */
public class Singleton {

	private static Singleton uniqueInstance = null;
	
	public Singleton() {}
	
	public static Singleton getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
	 
}
