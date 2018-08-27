package DesignPattern.Singleton;

/**
 * 双重检验锁
 * @author ygsama
 *
 */
public class Singleton6 {
    
    private volatile static Singleton6 uniqueInstance;
    private Singleton6(){}
    public static Singleton6 getSingletonDemo(){
        if (uniqueInstance == null) {
            synchronized (Singleton6.class) {
                if (uniqueInstance == null) {
                	uniqueInstance = new Singleton6();
                }
            }
        }
        return uniqueInstance;
    }
}
