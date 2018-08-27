package DesignPattern.Singleton;

/**
 * 懒汉单例，线程安全
 * @author ygsama
 *
 */
public class Singleton2 {

	private static Singleton uniqueInstance = null;
	
	public Singleton2() {}
	
	public static synchronized Singleton getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
}
