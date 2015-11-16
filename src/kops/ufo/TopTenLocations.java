package kops.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class TopTenLocations {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("ufo_awesome.json"));
		
		final Gson gson = new Gson();
		
		UFOSighting array[] = gson.fromJson(in, UFOSighting[].class);	// returns a list of UFO sightings
		
		// create a HashMap to hold locations and how often they appear in the file
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		
		//read through array and either add location to HashMap or increment amount for location
		
		Integer numFound = 0;
		for ( UFOSighting ufo: array ) {
	            numFound = map.get(ufo.getLocation());	//the amount of times this location was reported
	            if (numFound == null) {
	                map.put(ufo.getLocation(), 1);
	            }
	            else {
	            	numFound = map.get(ufo.getLocation());
	                map.put(ufo.getLocation(), numFound + 1);	//increase this location's occurrences by one
	            }
	        }
		
		
		
		//find and print the top ten locations from the HashMap 
		String topLocation = null;
		int topSightings = 0;
		for(int i = 0; i < 10; i++){
			for(Map.Entry<String, Integer> entry : map.entrySet()){
				if(entry.getValue() > topSightings){
					topSightings = entry.getValue();
					topLocation = entry.getKey();
				}
				
			
			
			}
			
			
			System.out.println((i+1) +"."+topLocation+" - " +map.get(topLocation)+" sightings");
			map.remove(topLocation);
			topLocation = null;
			topSightings = 0;
		}
		in.close();
	}

}
