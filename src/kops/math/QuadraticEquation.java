package kops.math;

public class QuadraticEquation {

	private double a;
	private double b;
	private double c;

	public QuadraticEquation(double a, double b, double c) {

		// don't put this in
		/*if(a <= 0 || b <= 0){	// not possible to calculate roots
			System.exit(0);
		}*/
		
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getPositiveX() {

		return (-(b) + (Math.sqrt(b * b - (4 * a * c)))) / (2 * a);
	}

	public double getNegativeX() {

		return (-(b) - (Math.sqrt(b * b - (4 * a * c)))) / (2 * a);

	}
}
