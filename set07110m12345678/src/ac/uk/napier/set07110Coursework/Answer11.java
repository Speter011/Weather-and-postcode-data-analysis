package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;
import java.util.HashMap;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import Classes.Postcode;
import Classes.PostcodeCreator;
import Classes.WeatherStation;
import Classes.WeatherStationCreator;
import gui.MapGui;
import weather.WeatherData;

/**
 * QUESTION 11
 * 
 * If you decide to answer question 11 then the main method below should be used as the entry point for your application
 * You may use as many other classes as you feel necessary as long as all code is supplied 
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer11 {
	public static void main(String[] args) {
		System.out.println("Question 11");
		/*
		 * Add your code below
		 */
		
		HashMap<Integer, WeatherStation> weatherStations = WeatherStationCreator.getHashMap();
		
		//create a ArrayList for the postcodes and populate it
		ArrayList<Postcode> postcodes = new ArrayList<>();
		postcodes = PostcodeCreator.getPostcodes();
		
		//we get the WeatherStation object containing the Inverbervie using it's id (3088) and store it's coordinates
		
		double latitude3088 = weatherStations.get(3088).getLat();
		double longitude3088 = weatherStations.get(3088).getLon();
		
		//we create an ArrayList, which we can use to store the coordinates later
		ArrayList<Coordinate> coordinates = new ArrayList<>();
		//counter to count the number of postcodes near Inverbervie
		int count = 0;
		
		//for each loop : using the postcodes ArrayList and iterating through it with Postcode objects
		for(Postcode postcode : postcodes){
				
				//current postcode's coordinates
				double latitudeI = postcode.getLat();
				double longitudeI = postcode.getLon();
				
				//we check if the distance between Inverbervie and the current postcode is smaller than 5 km, 
				//if it is we get the coordinates of those postcodes so we can show them using MapGui
				if(WeatherData.getDistanceBetweenPoints(latitude3088, longitude3088, latitudeI, longitudeI) < 5 ) {
				coordinates.add(new Coordinate(latitudeI, longitudeI));
				
				count++;
				}
		}
		//we print the solutions, and show the postcodes on a map
		System.out.println("There are " + count + " postcodes near INVERBERVIE (3088).");
		MapGui.showMap(coordinates);
		
	}	
}
