package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;
import java.util.HashMap;

import Classes.WeatherReading;
import Classes.WeatherStation;
import Classes.WeatherStationCreator;

/**
 * QUESTION 13
 * 
 * If you decide to answer question 13 then the main method below should be used as the entry point for your application
 * You may use as many other classes as you feel necessary as long as all code is supplied 
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer13 {
	public static void main(String[] args) {
		System.out.println("Question 13");
		/*
		 * Add your code below
		 */
		//variables:
		//selfexplenatory names
		//difference is the difference between the mean values
		//counter : for counting the number of readings
		double meanTemperature3068 = 0;
		double meanTemperature3166 = 0;
		double temperature3068 = 0;
		double temperature3166 = 0;
		double difference = 0;
		
		int counter = 0;
		
		HashMap<Integer, WeatherStation> weatherStations = WeatherStationCreator.getHashMap();
		
		//we put the readings corresponding to the two places into their own ArrayLists
		ArrayList<WeatherReading> weatherReadings3068 = new ArrayList<>();
		ArrayList<WeatherReading> weatherReadings3166 = new ArrayList<>();
		
		weatherReadings3068 = weatherStations.get(3068).getWeatherReadings();
		weatherReadings3166 = weatherStations.get(3166).getWeatherReadings();
		
		//we iterate through the readings at the first location
		//adding together every temperature (if it was measured in march) and counting the number of readings
		for(WeatherReading weatherReading: weatherReadings3068) {
			if(weatherReading.getMonth() == 3) {
				temperature3068 += weatherReading.getTemperature();
				counter++;
			}
		}
		
		//we get the mean value by deviding our two values
		meanTemperature3068 = temperature3068/counter;

		//we reset the counter for the second loop
		counter = 0;
		//we basicly do the same thing for the second location
		for(WeatherReading weatherReading: weatherReadings3166) {
			if(weatherReading.getMonth() == 3) {
				temperature3166 += weatherReading.getTemperature();
				counter++;
			}
		}
		//getting the mean value is also the same
		meanTemperature3166 = temperature3166/counter;
		
		//we calculate the difference between the mean temperatures
		//I also use the Math.abs() method so we recieve the absolute value of the difference 
		difference = Math.abs(meanTemperature3068 - meanTemperature3166);
		
		//we print the solutions
		System.out.println("The difference between LOSSIEMOUTH's (3068), and EDINBURGH/GOGARBANK's (3166) mean temperature in March of 2015 was " + difference + ".");
		
	}	
}
