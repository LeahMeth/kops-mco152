package kops.math;

import org.junit.Assert;

import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetPositiveX(){
		QuadraticEquation q = new QuadraticEquation(1.0, 5.0, 6.0);
		double x = q.getPositiveX();
		
		Assert.assertEquals(-2, x, 0.01);
	}
	
	@Test
	public void testGetNegativeX(){
		QuadraticEquation qe = new QuadraticEquation(1.0, 5.0, 6.0);
		double y = qe.getNegativeX();
		
		Assert.assertEquals(-3, y, 0.01);
	}
}
