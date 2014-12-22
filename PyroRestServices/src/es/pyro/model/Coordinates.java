package es.pyro.model;

public class Coordinates {
	public Coordinates(){
		
	}

	public Coordinates (String coordinates){
		String[] coord = coordinates.split(" ");
		latitude = Double.parseDouble(coord[0].trim().substring(1, coord[0].trim().length()-1).replace(',', '.'));
		longitude = Double.parseDouble(coord[1].trim().substring(1, coord[1].trim().length()-1).replace(',', '.'));;
		altitude = Double.parseDouble(coord[2].trim().substring(1, coord[2].trim().length()-1).replace(',', '.'));
	}
	private double latitude;
	private double longitude;
	private double altitude;
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	
	
	public String getCoordinates(){
		return("["+this.getLatitude()+","+this.getLongitude()+","+this.getAltitude()+"]");
	}
      
	
}
