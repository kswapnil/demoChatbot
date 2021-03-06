package com.swap.demo.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value="/getDiveSites",method=RequestMethod.POST)
	public  @ResponseBody WebhookResponse getAllDiveSites(@RequestBody String country){

		Map<String, List<String>> mapCountries = new HashMap<>();
		List<String> listIndia = Arrays.asList("Planet Scuba India","Scuba Evolution India","Dive Goa","Temple Adventures");	
		mapCountries.put("India", listIndia);
		List<String> listUsa = Arrays.asList("PADI Americas","Divers Direct","Scuba Works","US Scuba Center");	
		mapCountries.put("USA", listUsa);
		List<String> listSrilanka = Arrays.asList("Poseidon Diving Centre Mirissa","Pearl Divers PADI","Island Scuba","Submarine Diving");	
		mapCountries.put("CUBA", listSrilanka);
		String key=null;
		try{
		JSONObject jsonObj = new JSONObject(country);
		JSONObject result=(JSONObject)jsonObj.get("result");
		JSONArray contexts=(JSONArray)result.get("contexts");
		JSONObject FirstJsonObject=(JSONObject)contexts.getJSONObject(0);
		JSONObject parameters=(JSONObject)FirstJsonObject.get("parameters");
		key=parameters.getString("geo-country.original");
		}
		catch(JSONException e){return new WebhookResponse("JSON parsing Exception","JSON parsing Exception");}
		
		if(mapCountries.containsKey(key)){
			return new WebhookResponse(mapCountries.get(key).toString(), mapCountries.get(key).toString());
		}
		return new WebhookResponse("Country not Found", "Country not Found");

	}
	 @RequestMapping(value="/hello",method = RequestMethod.POST)
	    public @ResponseBody WebhookResponse webhook(@RequestBody String obj){

	        System.out.println(obj);

	        return new WebhookResponse("Hello! " + obj, "Text " + obj);
	    }
	
}
