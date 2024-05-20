package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;
import java.util.Stack;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import Classes.FyPostcodeCreator;
import Classes.Postcode;
import gui.MapGui;
import weather.WeatherData;

/**
 * QUESTION 14
 * 
 * If you decide to answer question 14 then the main method below should be used
 * as the entry point for your application You may use as many other classes as
 * you feel necessary as long as all code is supplied
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run
 * configurations in eclipse
 */
public class Answer14 {
	public static void main(String[] args) {
		System.out.println("Question 14");
		/*
		 * Add your code below
		 */

		// variables:
		// distance : distance between the current postcode and one of its neighbour we
		// are currently checking
		// closestDistance : used for checking the closest distance between a postcode and its neighbour
		// mostLat, mostLon : coordinates of most isolated postcode
		// max : variable for checking the biggest distance between a postcodes and their closest neighbour
		// mostIsolatedPostcodeString : to store the postcodeString of the desired Postcode object
		double distance = 0;
		double closestDistance = 10000;
		double mostLat = 0;
		double mostLon = 0;
		double max = 0;
		String mostIsolatedPostcodeString;

		//create stack to store the postcodes, and their closest neighbours in
		Stack<Postcode> postcodeStack = new Stack<>();

		ArrayList<Coordinate> coordinates = new ArrayList<>();
		
		//create and populate postcode type ArrayList with the fy postcodes
		ArrayList<Postcode> postcodes = new ArrayList<>();
		postcodes = FyPostcodeCreator.getPostcodes();
		
		
		// create a new postcode object for the nearest neighbour
		Postcode closestNeighbourPostcode = postcodes.get(0);
		
		//create a new postcode for the most isolated postcode, which is the one we're looking for
		Postcode mostIsolatedPostcode = postcodes.get(0);

		//we iterate through the postcodes twice to calculate the distance between them and their neighbours
		for (Postcode postcode : postcodes) {
			// coordinates of the current location we are checking
			double currentLat = postcode.getLat();
			double currentLon = postcode.getLon();

			for (Postcode postcodeNeighbour : postcodes) {
				//we check that the neighbour postcode is not the same as the postcode we're compairing it to
				if(!postcodeNeighbour.equals(postcode)) {
				// coordinates of the neighbour we are currently checking
				double neighbourLat = postcodeNeighbour.getLat();
				double neighbourLon = postcodeNeighbour.getLon();

				// we calculate the distance between the postcodes
				distance = WeatherData.getDistanceBetweenPoints(currentLat, currentLon, neighbourLat, neighbourLon);
				// we get the lowest possible distance between the current postcode and all of its neighbours ,
				// we also set the closestNeighbourPostcode object this neighbour object
				if (distance < closestDistance) {
					closestDistance = distance;
					closestNeighbourPostcode = postcodeNeighbour;
				}

				}
			}
			//we push the postcode and its closest neighbour ontop of the stack
			//and reset the closestDistance checker
			postcodeStack.push(postcode);
			postcodeStack.push(closestNeighbourPostcode);
			closestDistance = 10000;

		}
		//we iterate through the stack pop-ing the postcode and its closest neighbour after eachother
		for (int i = 0; i < postcodes.size(); i++) {
			Postcode neighbour = postcodeStack.pop();
			Postcode postcode = postcodeStack.pop();
			//we get the biggest possible distance between the postcodes and their closest neighbours
			if (WeatherData.getDistanceBetweenPoints(neighbour.getLat(), neighbour.getLon(), postcode.getLat(),
					postcode.getLon()) > max) {
				max = WeatherData.getDistanceBetweenPoints(neighbour.getLat(), neighbour.getLon(), postcode.getLat(),
						postcode.getLon());
				mostIsolatedPostcode = postcode;
				
			}
		}
		
		mostIsolatedPostcodeString = mostIsolatedPostcode.getPostcodeString();
		mostLat = mostIsolatedPostcode.getLat();
		mostLon = mostIsolatedPostcode.getLon();
		coordinates.add(new Coordinate(mostLat, mostLon));
		
		//we print our solutions and show them on the map
		System.out.println("The most isolated postcode is: " + mostIsolatedPostcodeString + " at the location of :(" + mostLat
				+ ";" + mostLon + "). The distance to its closest neighbour is: " + max + " km.");
		
		
		MapGui.showMap(coordinates);
	}
}

