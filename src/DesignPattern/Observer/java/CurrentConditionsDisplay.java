package DesignPattern.Observer.java;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer,DisplayElement{
	
	private float temperature;
	private float humidity;
	private Observable weatherData;

	public CurrentConditionsDisplay(Observable weatherData) {
		this.weatherData = weatherData;
		this.weatherData.addObserver(this);
	}	
	
	void display(){
		System.out.println("Current conditions: " + temperature
				+ "F degrees and " + humidity +"% humidily");
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData w = (WeatherData)o;
			this.temperature = w.getTemperatrue();
			this.humidity = w.getHumidity();
			display();
		}
	}
}
