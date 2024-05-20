package Classes;

import java.util.ArrayList;
import java.util.HashMap;

import weather.WeatherData;

/**
 * 
 * We have only one method in this class which does two things first it creates a hashMap of the weather stations
 * after splitting up the data.
 * It also creates an ArrayList of type WeatherReading from the weather readings, and connects it to the correct 
 * weather Station.
 * The method returns the HashMap of weather stations 
 *  
 * 
 */

public class WeatherStationCreator {

public static HashMap <Integer , WeatherStation> getHashMap(){
		HashMap<Integer, WeatherStation> weatherStationHashMap = new HashMap<>();
		
		
		String[] data = WeatherData.getData();
		
		for(int i = 1; i < data.length; i++) {
			
			String line = data[i];
			
			String[] elements = line.split(",");
			
			String idString = elements[0];
			String name = elements[1];
			String latString = elements[2];
			String lonString = elements[3];

			int id = Integer.parseInt(idString);
			double lat = Double.parseDouble(latString);
			double lon = Double.parseDouble(lonString);
			
			
			WeatherStation weatherStation = new WeatherStation(lat, lon, id, name);
			
			
						
			weatherStationHashMap.put(id, weatherStation);
				
		}
			
		ArrayList<WeatherReading> weatherReadingsArray= new ArrayList<>();

		
		for(int i = 1; i < data.length; i++) {
			
				String line = data[i];
			
				String[] elements = line.split(",");
				String idString = elements[0];
				String yearString = elements[4];
				String monthString = elements[5];
				String dateString = elements[6];
				String hourString = elements[7];
				String windSpeedString = elements[8];
				String temperatureString = elements[9];
				
				int id = Integer.parseInt(idString);
				int year = Integer.parseInt(yearString);
				int month = Integer.parseInt(monthString);
				int date = Integer.parseInt(dateString);
				int hour = Integer.parseInt(hourString);
				int windSpeed = Integer.parseInt(windSpeedString);
				double temperature = Double.parseDouble(temperatureString);
				
				
				//create new WeatherReading object 
				WeatherReading weatherReading = new WeatherReading(year, month, date, hour, windSpeed, temperature);
				//add corresponding weatherReading object to the weatherReading ArrayList
				weatherStationHashMap.get(id).getWeatherReadings().add(weatherReading);
				
				weatherReadingsArray.add(weatherReading);	
				
				
				
				
		}
		
		return weatherStationHashMap;	
		
	}

}
