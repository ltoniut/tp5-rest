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
@Table(name = "ciudad")

@Getter
@Setter
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class City {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "nombre", nullable = false)
	private String name;

	@Column(name = "iata", nullable = false)
	private String iataCode;

	@JoinColumn(name = "id_estado")
	@ManyToOne(fetch = FetchType.LAZY)
	private State state;

	public City(long id, String name, String iataCode, State state) {
		this.id = id;
		this.name = name;
		this.iataCode = iataCode;
		this.state = state;
	}

	public City(String name, String iataCode, State state) {
		this.name = name;
		this.iataCode = iataCode;
		this.state = state;
	}

	@Override
	public String toString() {
		String to = "", stateString = "null";

		if (this.state != null)
			stateString = this.state.toString();

		to = this.name + " (" + this.iataCode + ") - " + stateString;

		return to;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || !(o instanceof City))
			return false;

		City city = (City) o;
		return this.id == city.getId() && this.name.equals(city.getName()) && this.iataCode.equals(city.getIataCode())
				&& this.state.equals(city.getState());
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

}
