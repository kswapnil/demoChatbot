package com.swap.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value="/getDiveSites/{country}",method=RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody List<String> getAllDiveSites(@PathVariable("country")String country){

		Map<String, List<String>> mapCountries = new HashMap<>();
		List<String> listIndia = Arrays.asList("Planet Scuba India","Scuba Evolution India","Dive Goa","Temple Adventures");	
		mapCountries.put("India", listIndia);
		List<String> listUsa = Arrays.asList("PADI Americas","Divers Direct","Scuba Works","US Scuba Center");	
		mapCountries.put("USA", listUsa);
		List<String> listSrilanka = Arrays.asList("Poseidon Diving Centre Mirissa","Pearl Divers PADI","Island Scuba","Submarine Diving");	
		mapCountries.put("CUBA", listSrilanka);
		
		if(mapCountries.containsKey(country)){
			return mapCountries.get(country);
		}
		return null;

	}
}
