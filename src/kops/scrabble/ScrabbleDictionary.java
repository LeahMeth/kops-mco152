package kops.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleDictionary {

	private String word;

	public ScrabbleDictionary(String word) {
		this.word = word;
	}

	/**
	 * @return true if the word is in the dictionary. If not, return false
	 */
	public boolean contains() {

		Scanner fileinput;
		ArrayList<String> list = new ArrayList<String>();

		try {
			fileinput = new Scanner(new File("US.dic"));

			// read through file and add each word to the ArrayList
			while (fileinput.hasNext()) {
				String w = fileinput.next();
				list.add(w);	
			}
			
			// check if the filled ArrayList does not contain the word
			if (!(list.contains(this.word))) {
				fileinput.close();
				return !(list.contains(this.word));
			}

			
			
		} catch (FileNotFoundException e) {
			e.getMessage();
		}

		

		// if a match is found, the word is in the dictionary
			return true;

	}
}
