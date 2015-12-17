package kops.weather;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TestWeatherGUI {

	@Test
	public void TestWeatherGUI(){
		JsonReader jr = new JsonReader("11367");
		
		Assert.assertEquals(46.94, jr.getTemp(), .1);
		
		Assert.assertEquals("light rain", jr.getDescription());
			
	}
	
}
