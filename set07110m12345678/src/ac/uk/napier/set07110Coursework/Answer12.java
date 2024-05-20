package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;
import java.util.HashMap;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import Classes.WeatherReading;
import Classes.WeatherStation;
import Classes.WeatherStationCreator;
import gui.MapGui;

/**
 * QUESTION 12
 * 
 * If you decide to answer question 12 then the main method below should be used as the entry point for your application
 * You may use as many other classes as you feel necessary as long as all code is supplied 
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer12 {
	public static void main(String[] args) {
		System.out.println("Question 12");
		/*
		 * Add your code below
		 */
		//variables: 
		//count : for getting the number of consecutive readings
		//id : Stationid of the station we need to print for the solution
		//maximum : maximum variable for getting the greatest number of consecutive readings
		//test : a variable which  we use to determine if the previous reading was greater than 50 km/h, 
		//if it was greater test is true 
		//if the previous reading was lower than 50 test is false (so by default we set it to false)
		
		int count = 0;
		int id = 0;
		int maximum = 0;
		boolean test= false;
		
		//stationName : the name of the station at the location where they recorded the
		//consecutive readings greater than 50
		String stationName = "";
		ArrayList<Coordinate> coordinates = new ArrayList<>();
		
		//HashMap for getting the stations
		//and ArrayList with the readings
		HashMap<Integer, WeatherStation> weatherStations = WeatherStationCreator.getHashMap();
		ArrayList<WeatherReading> weatherReadings = new ArrayList<>();
		
		//we iterate through the station ids using the keyset of the HashMap

		for(Integer stationId : weatherStations.keySet()) {
			weatherReadings = weatherStations.get(stationId).getWeatherReadings();
			//then we iterate through the readings at the specific stations
			for(WeatherReading weatherReading : weatherReadings) {
				
				//we check if the previous reading was above 50, and if the current one is above it
				//we only add to the count if the current one is above 50 
				//and if this is the first one in the current sequence we set test to true
				 
				if(weatherReading.getWindSpeed() > 50 && test) {
					count++;
				}
				if(weatherReading.getWindSpeed() > 50 && !test) {
					count++;
					test = true;
				}
				if(weatherReading.getWindSpeed() <= 50 && test) {
					//if the current reading is below 50 but the previous was above it, 
					//we check if the number of consecutive readings was greater than the current maximum value
					//we set the stationName and id to the corresponding values as well
					if(count > maximum) {
						maximum = count;
						stationName = weatherStations.get(stationId).getName();
						id = stationId;
					}
					//we must reset count and test to the default values if the current reading was below 50
					count = 0;
					test = false;
				}	
			}
			//we do the same after checking every station
			count = 0;
			test = false;
		}		
		
		//we print out the solutions and show our results using the MapGui
		coordinates.add(new Coordinate(weatherStations.get(id).getLat(),weatherStations.get(id).getLon())); 
		System.out.println("At location " + stationName +" (" + weatherStations.get(id).getLat() + ";" + weatherStations.get(id).getLon() + ") there were " + maximum + " consecutive wind speed readings greater than 50 km/h, which is the most out of all the stations.");
		MapGui.showMap(coordinates);
		
		
	
	}	
}
