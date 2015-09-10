package kops.math;

public class PythagoreanTheorem {

	private double a;
	private double b;
	private double c;

	public PythagoreanTheorem(double a, double b, double c) { // one of these
																// values might
																// be null
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * Sets the value of A and B and computes C
	 */
	public void setAB(double a, double b) {
		this.c = Math.sqrt(a * a + b * b);
	}

	/**
	 * Sets the value of A and C and computes B
	 */
	public void setAC(double a, double c) {
		this.b = Math.sqrt(c * c - a * a);
	}

	/**
	 * Sets the value of B and C and computes A
	 */
	public void setBC(double b, double c) {
		this.a = Math.sqrt(c * c - b * b);
	}

	public double getA() {
		setBC(this.b, this.c);
		return this.a;
	}

	public double getB() {
		setAC(this.a, this.c);
		return this.b;
	}

	public double getC() {
		setAB(this.a, this.b);
		return this.c;
	}
}
