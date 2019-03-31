package DesignPattern.Observer;

import java.util.ArrayList;

public class WeatherData implements Subject {
	
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	// 温度
	public float getTemperatrue(){
		return 1;
	}
	
	// 湿度
	public float getHumidity(){
		return 1;
	}
	
	// 气压
	public float getPressure(){
		return 1;
	}
	
	public void setMeasurements(float temperature,float humidity,float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChangeed();
	}
	
	// 气象测量更新
	void measurementsChangeed(){
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i>0){
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.update( temperature, humidity, pressure);
		}
	}
}
