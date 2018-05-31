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

import com.esq.models.Route;
import com.example.aeroperu.repo.RouteRepo;

@RestController
@RequestMapping(value = "/route", produces = "Application/Json")
public class RouteController {

    @Autowired
    RouteRepo routeDAO;

    /* to save an port */
    @PostMapping("/post")
    public Route createRoute(@Valid @RequestBody Route air) {
	return routeDAO.save(air);
    }

    /* get all port */
    @GetMapping("/get")
    public List<Route> getAllRoutes() {
	return (List<Route>) routeDAO.findAll();
    }

    /* get Route by airid */
    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Route>> getRouteById(@PathVariable(value = "id") Long airid) {

	Optional<Route> air = routeDAO.findById(airid);

	if (air == null) {
	    return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok().body(air);

    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable(value = "id") Long airid,
	    @Valid @RequestBody Route airDetails) {

	Optional<Route> air = routeDAO.findById(airid);
	if (air == null) {
	    return ResponseEntity.notFound().build();
	}

	Route port = new Route();
	port.setId(airid);
	port.setAirportBegin(airDetails.getAirportBegin());
	port.setAirportEnd(airDetails.getAirportEnd());
	port.setDistance(airDetails.getDistance());

	Route updateRoute = routeDAO.save(port);
	return ResponseEntity.ok().body(updateRoute);
	// return ResponseEntity.badRequest().build();

    }

    /* Delete an Route */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Route> deleteRoute(@PathVariable(value = "id") Long airid) {

	Optional<Route> air = routeDAO.findById(airid);
	if (air == null) {
	    return ResponseEntity.notFound().build();
	}
	routeDAO.deleteById(airid);

	return ResponseEntity.ok().build();

    }

}