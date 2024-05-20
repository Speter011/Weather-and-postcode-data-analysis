package Classes;

import org.openstreetmap.gui.jmapviewer.Coordinate;

/**
 * 
 * Postcode class defining the Postcode object, which extends the Coordinate class.
 * It has a constructor, using the lat, and lon  from the superclass, and a postcodeString which is just the 
 * postcode of the specific location.
 * It also has getters and setters for its variables.
 *
 */
public class Postcode extends Coordinate{
	
	private String postcodeString;
	private double longitude;
	private double latitude;
	
	//Constructor
	public Postcode(String code, double lat, double lon) {
		//using superclass's coordinate variables
		//and the postcode string
		super(lat, lon);
		this.postcodeString = code;
	}
	
	//returns the postcode of the object
	public String getPostcodeString() {
		return postcodeString;
	}
	
	public void setPostcodeString(String postcodeString) {
		this.postcodeString = postcodeString;
	}
	
	//returns the longitude of the postcode
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	//returns the latitude of the postcode
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	

}
