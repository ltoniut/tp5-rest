package com.esq.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ruta")

@Getter
@Setter
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @JoinColumn(name = "origen_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Airport airportBegin;

    @JoinColumn(name = "destino_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Airport airportEnd;

    @Column(name = "distancia", nullable = false)
    private int distance;

    public Route(long id, Airport airportBegin, Airport airportEnd, int distance) {
	this.id = id;
	this.airportBegin = airportBegin;
	this.airportEnd = airportEnd;
	this.distance = distance;

    }

    public Route(Airport airportBegin, Airport airportEnd, int distance, int estimatedTime) {
	this.airportBegin = airportBegin;
	this.airportEnd = airportEnd;
	this.distance = distance;

    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Route other = (Route) obj;
	if (airportBegin == null) {
	    if (other.airportBegin != null)
		return false;
	} else if (!airportBegin.equals(other.airportBegin))
	    return false;
	if (airportEnd == null) {
	    if (other.airportEnd != null)
		return false;
	} else if (!airportEnd.equals(other.airportEnd))
	    return false;
	if (distance != other.distance)
	    return false;
	if (id != other.id)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	String to = "", airportBeginString = "null", airportEndString = "null";

	if (this.airportBegin != null)
	    airportBeginString = this.airportBegin.toString();

	if (this.airportEnd != null)
	    airportEndString = this.airportEnd.toString();

	to = airportBeginString + " to " + airportEndString;

	return to;
    }

    public Route() {
	super();
	// TODO Auto-generated constructor stub
    }
}
