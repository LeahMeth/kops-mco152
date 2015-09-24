package kops.scrabble;

import org.junit.Test;

import org.junit.Assert;

public class ScrabbleDictionaryTest {

	@Test
	public void testContains(){
		ScrabbleDictionary sd = new ScrabbleDictionary("smile");
		boolean cont = sd.contains();
		
		Assert.assertEquals(true, cont);
		
	}
}