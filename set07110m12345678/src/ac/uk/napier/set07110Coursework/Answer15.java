package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import Classes.FyPostcodeCreator;
import Classes.Postcode;
import gui.MapGui;
import weather.WeatherData;

/**
 * QUESTION 15
 * 
 * If you decide to answer question 15 then the main method below should be used as the entry point for your application
 * You may use as many other classes as you feel necessary as long as all code is supplied 
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer15 {
	public static void main(String[] args) {
		System.out.println("Question 15");
		/*
		 * Add your code below
		 */
		//variables:
		//count : for the number of neighbours
		//distance : distance to neighbour
 		//max : biggest number of neighbours
		//mostLat , mostLon : coordinates of the most densely populated postcode
		//mostPostCode : the most densely populated postcode
		int count = 0;
		double distance = 0;
		int max = 0;
		double mostLat = 0;
		double mostLon = 0;
		String mostPostCode = " ";
		
		ArrayList<Coordinate> coordinates = new ArrayList<>();
		
		ArrayList<Postcode> postcodes = new ArrayList<>();
		postcodes = FyPostcodeCreator.getPostcodes();

		
		for(Postcode postcode : postcodes) {
			//coordinates of the current location we are checking
			double currentLat = postcode.getLat();
			double currentLon = postcode.getLon();
			
			for(Postcode postcodeNeighbour : postcodes) {
				//coordinates of the neighbour we are currently checking
				double neighbourLat = postcodeNeighbour.getLat();
				double neighbourLon = postcodeNeighbour.getLon();
				//distance between the current postcode and the neighbour
				distance = WeatherData.getDistanceBetweenPoints(currentLat, currentLon, neighbourLat, neighbourLon);
				//we check if it qualifies as a close neighbour (closer than 0.2 km)
				//and we exclude the instances where the distance is zero meaning the postcodes are the same
				if(distance  <= 0.2 && distance != 0) {
					//we add to the counter of neighbours
					count++;
					//we check if this is the biggest number of neighbours yet,
					//if it is we also get its coordinates and postcode
					if(count > max) {
						
						max = count;
						mostLat = currentLat;
						mostLon = currentLon;
						mostPostCode = postcode.getPostcodeString(); 
						
					}
					
				}
				
			}
			//we need to reset the counter after checking a postcode
			count = 0;

		}
		
		//we print the solutions and show the postcode on the map
		System.out.println(mostPostCode + " is the most densely populated postcode with " + max + " neighbours at the location of (" + mostLat + ";" + mostLon + ").");
		
		coordinates.add(new Coordinate(mostLat,mostLon));
		MapGui.showMap(coordinates);
		
	}	
}
