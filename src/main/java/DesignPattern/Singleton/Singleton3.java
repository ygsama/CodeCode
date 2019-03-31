package DesignPattern.Singleton;

/**
 * 饿汉单例
 * @author ygsama
 *
 */
public class Singleton3 {

	private static Singleton3 uniqueInstance = new Singleton3();
	
	public Singleton3() {}
	
	public static Singleton3 getInstance(){
		
		return uniqueInstance;
	}
	 
}
