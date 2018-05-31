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

import com.esq.models.Cabin;
import com.example.aeroperu.repo.CabinRepo;

@RestController
@RequestMapping(value = "/cabin", produces = "Application/Json")
public class CabinController {

    @Autowired
    CabinRepo cabinDAO;

    /* to save a cabin */
    @PostMapping("/post")
    public Cabin createCabin(@Valid @RequestBody Cabin air) {
	return cabinDAO.save(air);
    }

    /* get all cabins */
    @GetMapping("/get")
    public List<Cabin> getAllCabins() {
	return (List<Cabin>) cabinDAO.findAll();
    }

    /* get Cabin by id */
    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Cabin>> getCabinById(@PathVariable(value = "id") Long airid) {

	Optional<Cabin> air = cabinDAO.findById(airid);

	if (air == null) {
	    return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok().body(air);

    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Cabin> updateCabin(@PathVariable(value = "id") Long airid,
	    @Valid @RequestBody Cabin airDetails) {

	Optional<Cabin> air = cabinDAO.findById(airid);
	Cabin cabina = air.get();

	if (cabina == null) {
	    return ResponseEntity.notFound().build();
	}

	// Cabin port = new Cabin();
	cabina.setName(airDetails.getName());

	Cabin updateCabin = cabinDAO.save(cabina);
	return ResponseEntity.ok().body(updateCabin);

    }

    /* Delete a Cabin */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cabin> deleteCabin(@PathVariable(value = "id") Long airid) {

	Optional<Cabin> air = cabinDAO.findById(airid);
	if (air == null) {
	    return ResponseEntity.notFound().build();
	}
	cabinDAO.deleteById(airid);

	return ResponseEntity.ok().build();

    }
}