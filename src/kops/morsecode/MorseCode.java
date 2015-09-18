package kops.morsecode;

import java.util.ArrayList;

public class MorseCode {

	private String m;

	public MorseCode() {

		this.m = null;
	}

	public String encode(String message) {
		ArrayList<String> chars = new ArrayList<String>();
		Character c;
		StringBuilder buff = new StringBuilder();

		// put each character or space into an ArrayList
		for (int i = 0; i < message.length(); i++) {
			c = message.charAt(i);
			chars.add(c.toString());
		}

		// with a switch statement, switch every character to its morse
		// equivalent and append it to the StringBuffer
		for (String s : chars) {
			switch (s) {
			case "a":
				buff.append("._ ");
				break;
			case "b":
				buff.append("_... ");
				break;
			case "c":
				buff.append("_._. ");
				break;
			case "d":
				buff.append("_.. ");
				break;
			case "e":
				buff.append(". ");
				break;
			case "f":
				buff.append(".._. ");
				break;
			case "g":
				buff.append("__. ");
				break;
			case "h":
				buff.append(".... ");
				break;
			case "i":
				buff.append(".. ");
				break;
			case "j":
				buff.append(".___ ");
				break;
			case "k":
				buff.append("_._ ");
				break;
			case "l":
				buff.append("._.. ");
				break;
			case "m":
				buff.append("__ ");
				break;
			case "n":
				buff.append("_. ");
				break;
			case "o":
				buff.append("___ ");
				break;
			case "p":
				buff.append(".__. ");
				break;
			case "q":
				buff.append("__._ ");
				break;
			case "r":
				buff.append("._. ");
				break;
			case "s":
				buff.append("... ");
				break;
			case "t":
				buff.append("_ ");
				break;
			case "u":
				buff.append(".._ ");
				break;
			case "v":
				buff.append("..._ ");
				break;
			case "w":
				buff.append(".__ ");
				break;
			case "x":
				buff.append("_.._ ");
				break;
			case "y":
				buff.append("_.__ ");
				break;
			case "z":
				buff.append("__.. ");
				break;
			case " ":
				buff.append("   ");
				break;
			case "1":
				buff.append(".____ ");
				break;
			case "2":
				buff.append("..___ ");
				break;
			case "3":
				buff.append("...__ ");
				break;
			case "4":
				buff.append("...._ ");
				break;
			case "5":
				buff.append("..... ");
				break;
			case "6":
				buff.append("_.... ");
				break;
			case "7":
				buff.append("__... ");
				break;
			case "8":
				buff.append("___.. ");
				break;
			case "9":
				buff.append("____. ");
				break;
			case "0":
				buff.append("_____ ");
			default:
				buff.append("   ");
				break;

			}// end switch statement

		}

		return buff.toString();
	}

	public String decode(String code) {
		// break morse into parts (letters)
		String[] morseBits;
		morseBits = code.split(" ");
		int numOfBits = morseBits.length;
		StringBuffer buff = new StringBuffer();

		// for each part, replace with the English equivalent and add to
		// StringBuffer
		for (int i = 0; i < numOfBits; i++) {
			switch (morseBits[i]) {
			case "._":
				buff.append("a");
				break;
			case "_...":
				buff.append("b");
				break;
			case "_._.":
				buff.append("c");
				break;
			case "_..":
				buff.append("d");
				break;
			case ".":
				buff.append("e");
				break;
			case ".._.":
				buff.append("f");
				break;
			case "__.":
				buff.append("g");
				break;
			case "....":
				buff.append("h");
				break;
			case "..":
				buff.append("i");
				break;
			case ".___":
				buff.append("j");
				break;
			case "_._":
				buff.append("k");
				break;
			case "._..":
				buff.append("l");
				break;
			case "__":
				buff.append("m");
				break;
			case "_.":
				buff.append("n");
				break;
			case "___":
				buff.append("o");
				break;
			case ".__.":
				buff.append("p");
				break;
			case "__._":
				buff.append("q");
				break;
			case "._.":
				buff.append("r");
				break;
			case "...":
				buff.append("s");
				break;
			case "_":
				buff.append("t");
				break;
			case ".._":
				buff.append("u");
				break;
			case "..._":
				buff.append("v");
				break;
			case ".__":
				buff.append("w");
				break;
			case "_.._":
				buff.append("x");
				break;
			case "_.__":
				buff.append("y");
				break;
			case "__..":
				buff.append("z");
				break;
			case "  ":
				buff.append(" ");
				break;
			case ".____":
				buff.append("1");
				break;
			case "..___":
				buff.append("2");
				break;
			case "...__":
				buff.append("3");
				break;
			case "...._":
				buff.append("4");
				break;
			case ".....":
				buff.append("5");
				break;
			case "_....":
				buff.append("6");
				break;
			case "__...":
				buff.append("7");
				break;
			case "___..":
				buff.append("8");
				break;
			case "____.":
				buff.append("9");
				break;
			case "_____":
				buff.append("0");
			default:
				buff.append("   ");
				break;

			}// end switch statement
		}

		return buff.toString();
	}
}
