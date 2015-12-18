package kops.contacts;

import org.junit.Assert;
import org.junit.Test;

public class TestContacts {

	@Test
		public void TestContacts(){ 
		JsonReader reader = new JsonReader();
		
		Assert.assertEquals("Leanne Graham", reader.getContacts()[0].getName());
	}
}
