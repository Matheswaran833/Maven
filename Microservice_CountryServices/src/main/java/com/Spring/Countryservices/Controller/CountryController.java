package com.Spring.Countryservices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Countryservices.Beans.Country;
import com.Spring.Countryservices.Services.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	CountryService countryservice;
	
	@GetMapping("/getcountries")
	public List getcountries() 
	{
		return countryservice.getAllCountries();
	}
	
	@GetMapping("/getcountries/{id}")
	public Country getCountrybyId(@PathVariable(value="id")int id)
	{
		return countryservice.getCountrybyID(id);
	}
	
	@GetMapping("/getcountries/countryname")
	public Country getcountrybyName(@RequestParam(value="name")String countryname) 
	{
		return countryservice.getCountrybyname(countryname);
	}

	@PostMapping("/addcountry")
	public Country addcountry(@RequestBody Country country)
	{
		return countryservice.addCountry(country);
	}
	
	@PutMapping("/updatecountry")
	public Country updatecountry(@RequestBody Country country)
	{
		return countryservice.updateCountry(country);
	}
	
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse deletecountry(@PathVariable(value="id")int id)
	{
		return countryservice.deleteCountry(id);
	}
}
