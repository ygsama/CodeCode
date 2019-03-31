package DesignPattern.Observer.java;

import java.util.Observable;

public class WeatherData extends Observable {
	
	private float temperature;
	private float humidity;
	private float pressure;

	// 温度
	public float getTemperatrue(){
		return temperature;
	}
	
	// 湿度
	public float getHumidity(){
		return humidity;
	}
	
	// 气压
	public float getPressure(){
		return pressure;
	}
	
	// 气象测量更新
	void measurementsChangeed(){
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float temperature,float humidity,float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChangeed();
	}
	


}
