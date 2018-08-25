package DesignPattern.Observer.java;

/**
 * 通过使用Java自带的观察者模式接口实现从观察对象拉数据的操作
 * 
 * Java原生观察者模式(两种):
 * 		定义了对象之间的一对多依赖，这样当一个对象改变状态时，
 * 		1、它的所有注册的观察者既可以收到通知并更新，2、也可以选择主动拉取新数据
 * 缺点：
 * 		Observable是一个类，java不支持多重继承，限制了复用能力
 * 		Observable.setChange()被保护了起来，无法创建实例组合到自己的对象中，违反了多用组合少用继承的设计原则
 * 
 * @author ygsama
 *
 */
public class _Test {
	
	public static void main(String[] args) {
		WeatherData wd = new WeatherData();
		new CurrentConditionsDisplay(wd);
		wd.setMeasurements(80, 65, 30.4f);
	}
}
