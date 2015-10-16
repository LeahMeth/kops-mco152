package kops.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import com.google.gson.Gson;

public class UFOSightingMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new FileReader("ufo_awesome.json"));
		
		final Gson gson = new Gson();
		
		UFOSighting array[] = gson.fromJson(in, UFOSighting[].class);	// returns a list of UFO sightings
		
		System.out.println(array.length);
		
		
		in.close();
	}

}
