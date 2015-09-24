package kops.morsecode;

import java.util.HashMap;

public class MorseCode {

	private String m;

	public MorseCode() {

		this.m = null;
	}

	
	public String encode(String message) {

		HashMap<Character, String> map = new HashMap<Character, String>();
		
		// put keys and values into HashMap
		map.put('a', "._ ");
		map.put('b',"_... " );
		map.put('c', "_._. ");
		map.put('d', "_.. ");
		map.put('e', ". ");
		map.put('f', ".._. ");
		map.put('g', "__. ");
		map.put('h', ".... ");
		map.put('i', ".. ");
		map.put('j', ".___ ");
		map.put('k', "_._ ");
		map.put('l', "._.. ");
		map.put('m', "__ ");
		map.put('n', "_. ");
		map.put('o', "___ ");
		map.put('p', ".__. ");
		map.put('q', "__._ ");
		map.put('r', "._. ");
		map.put('s', "... ");
		map.put('t', "_ ");
		map.put('u', ".._ ");
		map.put('v', "..._ ");
		map.put('w', ".__ ");
		map.put('x', "_.._ ");
		map.put('y', "_.__ ");
		map.put('z', "__.. ");
		map.put(' ', "   ");
		map.put('1', ".____ ");
		map.put('2', "..___ ");
		map.put('3', "...__ ");
		map.put('4', "...._ ");
		map.put('5', "..... ");
		map.put('6', "_.... ");
		map.put('7', "__... ");
		map.put('8', "___.. ");
		map.put('9', "____. ");
		map.put('0', "_____ ");
		
		
		// Replace each english character with its morse equivalent and append to a StringBuilder
		Character c;	// each character in the original message
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < message.length(); i++){
			c = message.charAt(i);
			builder.append(map.get(c));
		}
			

		return builder.toString();
	}

	
	
	public String decode(String code) {
		// break morse into parts (letters)
		String[] morseBits;
		morseBits = code.split(" ");
		//int numOfBits = morseBits.length;
		StringBuilder builder = new StringBuilder();
		
		HashMap<String, String> map = new HashMap<String, String>();
		// put keys and values into HashMap
				map.put("._", "a");
				map.put("_...","b" );
				map.put("_._.", "c");
				map.put("_..", "d");
				map.put(".", "e");
				map.put(".._.", "f");
				map.put("__.", "g");
				map.put("....", "h");
				map.put("..", "i");
				map.put(".___", "j");
				map.put("_._", "k");
				map.put("._..", "l");
				map.put("__", "m");
				map.put("_.", "n");
				map.put("___", "o");
				map.put(".__.", "p");
				map.put("__._", "q");
				map.put("._.", "r");
				map.put("...", "s");
				map.put("_", "t");
				map.put(".._", "u");
				map.put("..._", "v");
				map.put(".__", "w");
				map.put("_.._", "x");
				map.put("_.__", "y");
				map.put("__..", "z");
				map.put("  ", " ");
				map.put(".____", "1");
				map.put("..___", "2");
				map.put("...__", "3");
				map.put("...._", "4");
				map.put(".....", "5");
				map.put("_....", "6");
				map.put("__...", "7");
				map.put("___..", "8");
				map.put("____.", "9");
				map.put("_____", "0");

		// for each part, replace with the English equivalent and append it to the StringBuilder
		for (String s: morseBits) {
			builder.append(map.get(s));
		}

		return builder.toString();
	}
}