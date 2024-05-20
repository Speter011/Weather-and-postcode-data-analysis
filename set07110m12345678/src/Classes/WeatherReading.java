package Classes;

/**
 * 
 * Class which has the WeatherReading object.
 * It also has getters and setters for its variables.
 *
 */

public class WeatherReading {
	
	//variables representing the time of the recording 
	private int year;
	private int month;
	private int date;
	private int hour;
	//variables for the values recorded, the wind speed, and temperature
	private int windSpeed;
	private double temperature;
	
	
	//Constructor
	public WeatherReading(int year, int month, int date, int hour, int windSpeed, double temperature) {
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.windSpeed = windSpeed;
		this.temperature = temperature;
		
		
	}
	
	//returns year of the recording of the data
	public int getYear() {
		return year;
	}

	//retuns the month of the recording
	public int getMonth() {
		return month;
	}
	
	//returns the day/date of the recording
	public int getDate() {
		return date;
	}

	//the hour in which the recording took place
	public int getHour() {
		return hour;
	}

	//returns the wind speed recorded
	public int getWindSpeed() {
		return windSpeed;
	}

	//returns the temperature recorded
	public double getTemperature() {
		return temperature;
	}

	//setters for the same variables
	
	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setWindSpeed(int windSpeed) {
		this.windSpeed = windSpeed;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
}
