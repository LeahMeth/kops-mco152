package kops.anagrams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
//import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
//import java.io.BufferedReader;

public class MostAnagrams {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileInput = new Scanner(new FileReader("./US.dic"));
		
		// create a HashSet that will hold groups of anagrams 
		HashSet<HashSet<String>> anagramGroups = new HashSet<HashSet<String>>();
		
		
		//For each word in the dictionary file: read it, and check if it belongs to an existing group of anagrams
		// if it does (= it is anagrams with the other words in a specific group), add it to the group
		// if it doesn't match any group, set up a new group with this word as its first word
		// Groups are HashMaps that hold related words as well as the first word in the group (to use later on foe comparing)
		
		String current;	// the current word comparing
		
		//set up first group and add it to HashSet of groups
		current = fileInput.next();
		HashSet<String> group1 = new HashSet<String>();
		group1.add(current);
		anagramGroups.add(group1);
		
		String tempWord;
		boolean isAnagram;
		boolean placedInGroup = false;
		MostAnagrams m = new MostAnagrams();
		
		
		while(fileInput.hasNext()){	// for each word in dictionary file
			current = fileInput.next();
			
			for(HashSet<String> group: anagramGroups){	// check each group
				
				//set up an iterator to get a value from this HashSet to use with comparing to the current word
				Iterator<String> itr = group.iterator();	
				tempWord = itr.next();
				
				// check if current word is anagrams with the word from this group		
				isAnagram = m.isAnagram(current, tempWord);
				if(isAnagram){
					group.add(current);
					placedInGroup = true;
				}

			}
			
			if(!placedInGroup){	//word wasn't anagrams with any existing group
				// set up a new group
				HashSet<String> newGroup = new HashSet<String>();
				newGroup.add(current);
				anagramGroups.add(newGroup);
			}
	
		}	//end while loop
		
		
		
		// now that have a HashSet of all groups, find and print the biggest group of anagrams
		HashSet<String> most = new HashSet<String>();
		//Iterator<HashSet<String>> iterator = anagramGroups.iterator();
		for(HashSet<String> group: anagramGroups){
			if(group.size() > most.size()){
				most = group;
				System.out.println(most.toString());
			}
			
		
		}
		
		System.out.println(most.toString());

	}
	
	public boolean isAnagram(String word1, String word2){
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		
		if(word1.length() != word2.length()){
			return false;
		}
		
		char[] charFromWord1 = word1.toCharArray();
        char[] charFromWord2 = word2.toCharArray();       
        Arrays.sort(charFromWord1);
        Arrays.sort(charFromWord2);
       
        return Arrays.equals(charFromWord1, charFromWord2);
		
	}

}
