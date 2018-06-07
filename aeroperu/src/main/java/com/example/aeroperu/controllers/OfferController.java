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

import com.esq.models.Offer;
import com.example.aeroperu.repo.OfferRepo;

@RestController
@RequestMapping(value = "/offer", produces = "Application/Json")
public class OfferController {

	@Autowired
	OfferRepo offerDAO;

	/* to save an port */
	@PostMapping("/post")
	public Offer createOffer(@Valid @RequestBody Offer air) {
		return offerDAO.save(air);
	}

	/* get all port */
	@GetMapping("/get")
	public List<Offer> getAllAirports() {
		return (List<Offer>) offerDAO.findAll();
	}

	/* get airport by airid */
	@GetMapping("/offer/{id}")
	public ResponseEntity<Optional<Offer>> getAirportById(@PathVariable(value = "id") Long airid) {

		Optional<Offer> air = offerDAO.findById(airid);

		if (air == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(air);

	}

	@PutMapping("/offer/{id}")
	public ResponseEntity<Offer> updateOffer(@PathVariable(value = "id") Long airid,
			@Valid @RequestBody Offer airDetails) {

		Optional<Offer> air = offerDAO.findById(airid);
		if (air == null) {
			return ResponseEntity.notFound().build();
		}

		Offer port = new Offer();
		port.setId(airid);
		port.setCabin(airDetails.getCabin());
		port.setFrom(airDetails.getFrom());
		port.setUntil(airDetails.getUntil());
		port.setPrice(airDetails.getPrice());
		port.setRoute(airDetails.getRoute());

		Offer updateAirport = offerDAO.save(port);
		return ResponseEntity.ok().body(updateAirport);
		// return ResponseEntity.badRequest().build();

	}

	/* Delete an airport */
	@DeleteMapping("/offer/{id}")
	public ResponseEntity<Offer> deleteAirport(@PathVariable(value = "id") Long airid) {

		Optional<Offer> air = offerDAO.findById(airid);
		if (air == null) {
			return ResponseEntity.notFound().build();
		}
		offerDAO.deleteById(airid);

		return ResponseEntity.ok().build();

	}
}