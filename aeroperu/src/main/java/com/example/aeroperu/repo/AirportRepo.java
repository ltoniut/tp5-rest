package com.example.aeroperu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esq.models.Airport;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Long> {
	public default Airport findByIata(String str) {
		for (Airport air : findAll()) {
			if (air.getIataCode() == str) {
				return air;
			}
		}
		return null;
	}
}