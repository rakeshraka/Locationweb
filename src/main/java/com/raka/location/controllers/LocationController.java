package com.raka.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raka.location.entities.Location;
import com.raka.location.repos.LocationRerpository;
import com.raka.location.service.LocationService;
import com.raka.location.util.EmailUtil;
import com.raka.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService service;
	
	@Autowired
	LocationRerpository repo;
	
	@Autowired
	ReportUtil util;
	
	@Autowired
	ServletContext sc;
	
	
	@Autowired
	private EmailUtil emailUtil;
	
	@RequestMapping(value = {"/showCreate","/"})
	public String showCreate()
	{
		return "createLocation";
	}
	
	@RequestMapping(value = "/saveLocation")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap  modelMap)
	{
		Location loc = service.saveLocation(location);
		String msg = "Location saved with id:"+loc.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendMail("kashyap.mannat@gmail.com", "Location Saved by RAKA", "Location Saved Successfully and return a response."
				+ "Location Data \n"
				+ "Location ID:"+location.getId()+"\n"
				+ "Location Code:"+location.getCode()+"\n"
				+ "Location Name:"+location.getName()+"\n"
				+ "Location Type:"+location.getType());
		
		
		return "createLocation";
	}

	@RequestMapping("/displayAllLocation")
	public String displayAllLocation(ModelMap modelMap)
	{
		List<Location> allLocation = service.getAllLocation();
		modelMap.addAttribute("locations", allLocation);
		return "displayAllLocation";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap)
	{
		Location location = service.getLocationById(id);
		service.deleteLocation(location);
		List<Location> allLocations = service.getAllLocation();
		modelMap.addAttribute("locations", allLocations);
		
		emailUtil.sendMail("kashyap.mannat@gmail.com", "Location Deleted by RAKA", "Location delete Successfully."
				+ "Location Data \n"
				+ "Location ID:"+id);

		return "displayAllLocation";
	}
	
	@RequestMapping("editLocation")
	public String editLocation(@RequestParam("id") int id,ModelMap modelMap)
	{
		Location location = service.getLocationById(id);
		modelMap.addAttribute("loc", location);
		return "editLocation";
	}
	
	@RequestMapping("/updateLocation")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap  modelMap)
	{
		service.updateLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		emailUtil.sendMail("kashyap.mannat@gmail.com", "Location Updated by RAKA", "Location update successfully."
				+ "Location Data \n"
				+ "Location ID:"+location.getId()+"\n"
				+ "Location Code:"+location.getCode()+"\n"
				+ "Location Name:"+location.getName()+"\n"
				+ "Location Type:"+location.getType());
		return "displayAllLocation";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport()
	{
		List<Object[]> data = repo.findTypeAndTypeCount();
		String path = sc.getRealPath("/");
		util.generatePiaChart(path, data);
		return "report";
	}
	
}
