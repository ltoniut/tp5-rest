package com.example.aeroperu.pojo;

public class AirportPOJO {
    private String iataCode;
    private String name;
    private String cityIata;
    private float latitude;
    private float longitude;

    public AirportPOJO(long id, String name, String iataCode, String city, float latitude, float longitude) {
		this.name = name;
		this.iataCode = iataCode;
		this.cityIata = city;
		this.latitude = latitude;
		this.longitude = longitude;
    }

	public String getIataCode() {
		return iataCode;
	}

	public String getName() {
		return name;
	}

	public String getCityIata() {
		return cityIata;
	}

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}
}
