package kops.scrabble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {

	private String word;

	public ScrabbleDictionary(String word) {
		this.word = word;
	}

	/**
	 * @return true if the word is in the dictionary. If not, return false
	 * @throws IOException 
	 */
	public boolean contains() throws IOException {

		BufferedReader fileinput;
		HashSet<String> set = new HashSet<String>();

		
		try {
			fileinput = new BufferedReader(new FileReader("./US.dic"));

			// read through file and add each word to the set
			String line;
			while ((line = fileinput.readLine())!=null) {
	
				set.add(line);	
			}
			fileinput.close();

			
		} catch (FileNotFoundException e) {
			e.getMessage();
			
		}

		
		// check if the filled set contains the word and return result			
		return set.contains(this.word);

	}
}