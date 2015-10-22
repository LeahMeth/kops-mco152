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
		String location;
		Integer numFound;
		for (int i = 0; i < array.length; i++){	//first access the sighting's location
			
			UFOSighting sighting = new UFOSighting(array[i]);
			location = sighting.getLocation();
			
			numFound = map.get(location);
		///////////////////////////////////why nulls?////////////////////	
			if(numFound == null){
				map.put(location, 1);	//add location
			}
			else{
				map.put(location, numFound + 1);	//increment location's number of sightings
			}
			
		}
		
		
		//find and print the top ten locations from the HashMap 
		String topLocation = null;
		int topSightings = 0;
		for(int i = 0; i < 10; i++){
			for(Map.Entry<String, Integer> entry : map.entrySet()){
				if(entry.getValue() > topSightings){
					topLocation = entry.getKey();
				}
			}
			
			System.out.println((i+1) +". "+topLocation+" - " +topSightings+" sightings");
			map.remove(topLocation);
		}
		in.close();
	}

}
