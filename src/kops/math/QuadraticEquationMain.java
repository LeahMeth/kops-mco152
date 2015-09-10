package kops.math;

public class QuadraticEquationMain {

	public static void main(String[] args) {
		
		double a = 1.0;
		double b = 5.0;
		double c = 6.0;
		
		double x1, x2;	// values for the two roots
		
		// create object
		QuadraticEquation q = new QuadraticEquation(a,b,c);
	
		// call object's getters to get roots 
		x1 = q.getPositiveX();
		x2 = q.getNegativeX();
		
		System.out.println("The roots are: "+x1+" and "+x2);
		
		

	}

}
