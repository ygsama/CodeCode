package DesignPattern.Observer;

/**
 * 自定义观察者模式：
 * 		定义了对象之间的一对多依赖，这样当一个对象改变状态时，它的所有注册的依赖者都会收到通知，并更新
 * 
 * 气象站：获取温度和气压
 * WeatherData对象：追踪气象站数据，并更新公告板
 * Display公告板：显示当前天气情况
 * 
 * 需要建立一个应用，利用WeatherData对象取得数据，并更新三个公告板(目前状况，气象统计，天气预报)
 * 公告板的数量会不断增加
 * 
 * @author ygsama
 *
 */
public class _Test {
	
	public static void main(String[] args) {
		WeatherData wd = new WeatherData();
		CurrentConditionsDisplay display = new CurrentConditionsDisplay(wd);
		wd.setMeasurements(80, 65, 30.4f);
		
	}

}
