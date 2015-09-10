package kops.math;

import org.junit.Assert;

import org.junit.Test;

public class PythagoreanTheoremTest {

	@Test
	public void testGetA(){
		PythagoreanTheorem p = new PythagoreanTheorem(3.0, 4.0, 5.0);
		double result = p.getA();
		
		Assert.assertEquals(3.0, result, 0.1);
	}
	
	@Test
	public void testGetB(){
		PythagoreanTheorem p = new PythagoreanTheorem(3.0, 4.0, 5.0);
		double result = p.getB();
		
		Assert.assertEquals(4.0, result, 0.1);
	}
	
	@Test
	public void testGetC(){
		PythagoreanTheorem p = new PythagoreanTheorem(3.0, 4.0, 5.0);
		double result = p.getC();
		
		Assert.assertEquals(5.0, result, 0.1);
	}
	
	
	
}
