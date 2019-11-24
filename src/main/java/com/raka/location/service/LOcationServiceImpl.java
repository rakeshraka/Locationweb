package com.raka.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raka.location.entities.Location;
import com.raka.location.repos.LocationRerpository;


@Service
public class LOcationServiceImpl implements LocationService {

	@Autowired
	LocationRerpository repository;
	
	@Override
	public Location saveLocation(Location location) {
		return repository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return repository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		repository.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Location> getAllLocation() {
		return repository.findAll();
	}

	
	public LocationRerpository getRepository() {
		return repository;
	}

	public void setRepository(LocationRerpository repository) {
		this.repository = repository;
	}


	
}
