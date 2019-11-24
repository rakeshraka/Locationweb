package com.raka.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raka.location.entities.Location;
import com.raka.location.repos.LocationRerpository;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

	@Autowired
	LocationRerpository locationRerpository;
	
	@GetMapping
	public List<Location> getLocations()
	{
		return locationRerpository.findAll();
	}
	
	@PostMapping
	public Location saveLocation(@RequestBody Location loc) {
		return locationRerpository.save(loc);
	}

	@PutMapping
	public Location updateLocation(@RequestBody Location loc) {
		return locationRerpository.save(loc);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id)
	{
		locationRerpository.deleteById(id);
	}

	@GetMapping("/{id}")
	public Location getLocationById(@PathVariable("id") int id)
	{
		return locationRerpository.findById(id).get();
	}

}
