package com.example.aeroperu.pojo;

import java.sql.Date;

public class OfferPOJO {
	private long route;
	private Date from;
	private Date until;
	private long cabin;
	private long price;
	
	public OfferPOJO(long route, Date from, Date until, long cabinId, long price) {
		this.route = route;
		this.from = from;
		this.until = until;
		this.cabin = cabinId;
		this.price = price;
	}

	public long getRoute() {
		return route;
	}

	public Date getFrom() {
		return from;
	}

	public Date getUntil() {
		return until;
	}

	public long getCabin() {
		return cabin;
	}

	public long getPrice() {
		return price;
	}
}
