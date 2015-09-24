package kops.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
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
		HashSet<String> set = new HashSet<String>();

		
		try {
			fileinput = new Scanner(new File("./US.dic"));

			// read through file and add each word to the set
			while (fileinput.hasNext()) {
				String w = fileinput.next();
				set.add(w);	
			}
			fileinput.close();

			
		} catch (FileNotFoundException e) {
			e.getMessage();
			
		}

		
		// check if the filled set contains the word and return result			
		return set.contains(this.word);

	}
}