package com.example.aeroperu.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.esq.models.City;
import com.example.aeroperu.repo.CityRepo;

public class CityController {

	@Autowired
	CityRepo cityDAO;

	/* get all cities */
	@GetMapping("/get")
	public List<City> getAllCabins() {
		return (List<City>) cityDAO.findAll();
	}

	/* get Cabin by id */
	@GetMapping("/get/{id}")
	public ResponseEntity<City> getCabinById(@PathVariable(value = "id") String str) {
		City city = cityDAO.findByIata(str);

		if (city == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(city);
	}
}
