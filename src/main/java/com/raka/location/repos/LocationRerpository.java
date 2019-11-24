package com.raka.location.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raka.location.entities.Location;

public interface LocationRerpository extends JpaRepository<Location, Integer> {
	
	@Query("select type,count(type) from Location group by type")
	public List<Object[]> findTypeAndTypeCount();

}
