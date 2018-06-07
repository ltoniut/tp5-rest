package com.example.aeroperu.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esq.models.City;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
	public default City findByIata(String str) {
		for (City c : findAll()) {
			if (c.getIataCode() == str) {
				return c;
			}
		}
		return null;
	}
}