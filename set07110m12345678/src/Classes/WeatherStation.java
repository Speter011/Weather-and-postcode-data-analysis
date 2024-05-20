package Classes;

import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.Coordinate;

/**
 * 
 * WeatherStation class which extends the Coordinate class. It has a constructor with the superclass's lat 
 * and lon variables, and its own name and id.
 *
 */

public class WeatherStation extends Coordinate{
 
	//variables:
	//the readings corresponding to the weather stations
	//the id of the station
	//name of the station
	private ArrayList<WeatherReading> weatherReadings = new ArrayList<>() ;
	private int id;
	private String name;
	
	//Constructor
	public WeatherStation(double lat, double lon, int id, String name) {
		//using the coordinates of the station from the superclass
		//and the id and name of the station
		super(lat, lon);
		this.name = name;
		this.id = id;
	}

	//returns id of the station
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//returns name of the station
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//returns weather reading measered at the station
	public ArrayList<WeatherReading> getWeatherReadings(){
		return weatherReadings;
	}
	
	//toString method to print the weather station's name and id
	@Override
	public String toString() {
		return "WeatherStation [id=" + id + ", name=" + name + "]";
	}

	
	
}
