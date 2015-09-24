package kops.scrabble;

import java.io.IOException;

import org.junit.Test;
import org.junit.Assert;

public class ScrabbleDictionaryTest {

	@Test
	public void testContains() throws IOException{
		ScrabbleDictionary sd = new ScrabbleDictionary("smile");
		boolean cont = sd.contains();
		
		
		Assert.assertEquals(true, cont);
		
	}
}