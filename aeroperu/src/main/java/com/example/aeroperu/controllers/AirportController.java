package com.example.aeroperu.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esq.models.Airport;
import com.esq.models.City;
import com.example.aeroperu.pojo.AirportPOJO;
import com.example.aeroperu.repo.AirportRepo;
import com.example.aeroperu.repo.CityRepo;

@RestController
@RequestMapping(value = "/airport", produces = "Application/Json")
public class AirportController {

	@Autowired
	AirportRepo airportDAO;
	@Autowired
	CityRepo cityDAO;

	/* to save an port */
	@PostMapping("/post")
	public Airport createAirport(@Valid @RequestBody AirportPOJO air) {
		City city = cityDAO.findByIata(air.getIataCode());
		Airport airport = null;
		
		if (city != null) {
			airport = new Airport(air.getName(), air.getIataCode(), city, air.getLatitude(), air.getLongitude());
			return airportDAO.save(airport);
		}

		return airport;
	}

	/* get all port */
	@GetMapping("/get")
	public List<Airport> getAllAirports() {
		return (List<Airport>) airportDAO.findAll();
	}

	/* get airport by airid */
	@GetMapping("/get/{iata}")
	public ResponseEntity<Airport> getAirportById(@PathVariable(value = "iata") String iata) {

		Airport air = airportDAO.findByIata(iata);

		if (air == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(air);

	}

	/* update an airport by airid */
	// @PutMapping("/port/{id}")
	//
	// public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody
	// Airport air) {
	//
	// Optional<Airport> air = airportDAO.findById(id);
	//
	// air = null; // airportDAO.existsById(id);
	//
	// if (null == air) {
	// return new ResponseEntity("No Customer found for ID " + id,
	// HttpStatus.NOT_FOUND);
	// }
	//
	// return new ResponseEntity(air, HttpStatus.OK);
	//
	// }
	@PutMapping("/put/{id}")
	public ResponseEntity<Airport> updateAirport(@PathVariable(value = "iata") String iata,
			@Valid @RequestBody AirportPOJO airDetails) {

		Airport air = airportDAO.findByIata(iata);
		if (air == null) {
			return ResponseEntity.notFound().build();
		}

		Airport port = new Airport();
		Optional<City> city = cityDAO.findById(airDetails.getCityId());
		
		port.setIataCode(airDetails.getIataCode());
		port.setName(airDetails.getName());
		port.setLatitude(airDetails.getLatitude());
		port.setLongitude(airDetails.getLongitude());
		
		if (city.isPresent())
			port.setCity(city.get());

		Airport updateAirport = airportDAO.save(port);
		return ResponseEntity.ok().body(updateAirport);
		// return ResponseEntity.badRequest().build();

	}

	/* Delete an airport */
	@DeleteMapping("/delete/{iata}")
	public ResponseEntity<Airport> deleteAirport(@PathVariable(value = "id") String iata) {
		Airport air = airportDAO.findByIata(iata);
		if (air == null) {
			return ResponseEntity.notFound().build();
		}
		airportDAO.deleteById(air.getId());

		return ResponseEntity.ok().build();

	}
}