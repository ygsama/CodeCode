package DesignPattern.Singleton;

/**
 * 静态内部类
 * @author ygsama
 *
 */
public class Singleton4 {

	private static class SingletonHolder{
		 private static final Singleton4 instance = new Singleton4();
    }
    private Singleton4(){}
    public static final Singleton4 getInsatance(){
        return SingletonHolder.instance;
    }
}
