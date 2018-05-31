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
import com.example.aeroperu.repo.AirportRepo;

@RestController
@RequestMapping(value = "/air", produces = "Application/Json")
public class AirportController {

    @Autowired
    AirportRepo airportDAO;

    /* to save an port */
    @PostMapping("/port")
    public Airport createAirport(@Valid @RequestBody Airport air) {
	return airportDAO.save(air);
    }

    /* get all port */
    @GetMapping("/port")
    public List<Airport> getAllAirports() {
	return (List<Airport>) airportDAO.findAll();
    }

    /* get airport by airid */
    @GetMapping("/port/{id}")
    public ResponseEntity<Optional<Airport>> getAirportById(@PathVariable(value = "id") Long airid) {

	Optional<Airport> air = airportDAO.findById(airid);

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
    @PutMapping("/port/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable(value = "id") Long airid,
	    @Valid @RequestBody Airport airDetails) {

	Optional<Airport> air = airportDAO.findById(airid);
	if (air == null) {
	    return ResponseEntity.notFound().build();
	}

	Airport port = new Airport();
	port.setId(airid);
	port.setIataCode(airDetails.getIataCode());
	port.setName(airDetails.getName());
	port.setLatitude(airDetails.getLatitude());
	port.setLongitude(airDetails.getLongitude());
	port.setCity(airDetails.getCity());

	Airport updateAirport = airportDAO.save(port);
	return ResponseEntity.ok().body(updateAirport);
	// return ResponseEntity.badRequest().build();

    }

    /* Delete an airport */
    @DeleteMapping("/port/{id}")
    public ResponseEntity<Airport> deleteAirport(@PathVariable(value = "id") Long airid) {

	Optional<Airport> air = airportDAO.findById(airid);
	if (air == null) {
	    return ResponseEntity.notFound().build();
	}
	airportDAO.deleteById(airid);

	return ResponseEntity.ok().build();

    }
}