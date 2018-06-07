package com.esq.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "aeropuerto")

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class Airport {
    @Id
    @GeneratedValue

    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "iata", nullable = false)
    private String iataCode;

    @Column(name = "nombre", nullable = false)
    private String name;

    @JoinColumn(name = "id_ciudad")
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @Column(name = "langitud", nullable = false)
    private float latitude;

    @Column(name = "latitud", nullable = false)
    private float longitude;

    public Airport(long id, String name, String iataCode, City city, float latitude, float longitude) {
		this.id = id;
		this.name = name;
		this.iataCode = iataCode;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
    }

    public Airport(String name, String iataCode, City city, float latitude, float longitude) {
		this.name = name;
		this.iataCode = iataCode;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
    }

    @Override
    public String toString() {
		String to = "", cityString = "null";
	
		if (this.city != null)
		    cityString = this.city.toString();
	
		to = this.name + " (" + this.iataCode + ") - " + this.city.toString();
	
		return to;
    }

    @Override
    public boolean equals(Object o) {
		if (this == o)
		    return true;
		if (o == null || !(o instanceof Airport))
		    return false;
	
		Airport airport = (Airport) o;
		return this.id == airport.getId() && this.name.equals(airport.getName())
			&& this.iataCode.equals(airport.getIataCode()) && this.city.equals(airport.getCity())
			&& this.latitude == airport.getLatitude() && this.longitude == airport.getLongitude();
	    }
	
	    public Airport() {
		super();
		// TODO Auto-generated constructor stub
    }

}
