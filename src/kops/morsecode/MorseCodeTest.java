package kops.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testEncode(){
		MorseCode m = new MorseCode();
		String result = m.encode("smile");
		
		Assert.assertEquals("... __ .. ._.. . ", result);
	}
	
	@Test
	public void testDecode(){
		MorseCode m = new MorseCode();
		String result = m.decode("... __ .. ._.. .");
		
		Assert.assertEquals("smile", result);
	}
}
