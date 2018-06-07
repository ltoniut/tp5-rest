package com.aeroperu.tests;
import java.util.Optional;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.esq.models.Airport;
import com.esq.models.City;
import com.esq.models.Country;
import com.esq.models.State;
import com.example.aeroperu.controllers.CityController;
import com.example.aeroperu.repo.CityRepo;

import junit.framework.TestCase;

public class AirportTests extends TestCase {
	@Autowired
	CityRepo cityDAO;
	
	Airport existing;
	
	Airport valid;
	Airport invalidCity;
	Airport noName;
	Airport duplicateId;
	
	Long nonExisting;
	
	@Before
	public void setUp() {		
		City city = cityDAO.findById((long) 1).get();
		City invalidCity = new City("Fantasia", "FAN", new State());
		
		valid = new Airport ("Valido", "EZE", city, (float) 24.22, (float) 107.58);
	}
}
