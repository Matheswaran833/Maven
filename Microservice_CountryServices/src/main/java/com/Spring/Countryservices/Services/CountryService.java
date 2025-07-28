package com.Spring.Countryservices.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.Spring.Countryservices.Beans.Country;
import com.Spring.Countryservices.Controller.AddResponse;

@Component
public class CountryService {
	
	static HashMap<Integer,Country> CountryIdMap;
	
public CountryService() {
	CountryIdMap=new HashMap<Integer,Country>();
	Country IndiaCountry=new Country(1,"India","Delhi");
	Country UsaCountry=new Country(2,"USA","Washington");
	Country UKCountry=new Country(3,"UK","London");
	
	CountryIdMap.put(1,IndiaCountry);
	CountryIdMap.put(2,UsaCountry);
	CountryIdMap.put(3,UKCountry);
}

public List getAllCountries() {
	List countries=new ArrayList(CountryIdMap.values());
	return countries;
}

public Country getCountrybyID(int id) {
	Country country=CountryIdMap.get(id);
	return country;
}
	
public Country getCountrybyname(String countryName) {
	Country country=null;
	for(int i:CountryIdMap.keySet())
	{
		if(CountryIdMap.get(i).getCountryName().equals(countryName))
			country=CountryIdMap.get(i);
	}
	return country;
}

public Country addCountry(Country country) {
	country.setId(getmaxid());
	CountryIdMap.put(country.getId(), country);
	return country;
   }
	//utility method to getmaxid
	public static int getmaxid() {
		int max=0;
		for(int id:CountryIdMap.keySet())
			if(max<=id)
				max=id;
		return max+1;
	}
	
public Country updateCountry(Country country) {
	if(country.getId()>0)
		CountryIdMap.put(country.getId(), country);
	return country;
}

public AddResponse deleteCountry(int id)
{
	CountryIdMap.remove(id);
	AddResponse res=new AddResponse();
	res.setMsg("country deleted");
	res.setId(id);
	return res;
}


}
