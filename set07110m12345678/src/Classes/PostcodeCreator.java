package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * The getPostcodes() method which returns an ArrayList of type Postcode from the postcodes.csv, 
 * containing all the postcodes.
 * 
 */
public class PostcodeCreator {
	
	
	public static ArrayList<Postcode> getPostcodes(){
	ArrayList<Postcode> postcodes = new ArrayList<>();
		
	try {
		
		//We use a Buffered Reader to read the file line by line
		BufferedReader reader = new BufferedReader(new FileReader(new File("set07110m12345678/data/postcodes.csv")));
				
		String line;
	
		//continue reading until null is returned when the end of the file has been reached
		while((line = reader.readLine())!= null){
			
			//printing every line is computationally expensive 
			//System.out.println(line);

			
			//we can use the split method of String to extract the individual fields from the comma delimited line to an array
			String[] data = line.split(",");
			
			//fields 1 and 2 hold the latitude and longitude which need converted to type double
			//field 0 holds the postcode which is in type string
			
			Postcode postcode = new Postcode(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]));
			postcodes.add(postcode);
			
		}
		
		reader.close();
	
	} catch (FileNotFoundException e) {			
		e.printStackTrace();
	} catch (IOException e) {			
		e.printStackTrace();
	} catch (NumberFormatException e) {			
		e.printStackTrace();
	}
	return postcodes;
}
}
	
