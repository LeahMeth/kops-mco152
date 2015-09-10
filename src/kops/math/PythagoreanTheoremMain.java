package kops.math;

public class PythagoreanTheoremMain {

	public static void main(String[] args) {

		double a = 3.0;
		double b = 4.0;
		double c = 5.0;

		PythagoreanTheorem p = new PythagoreanTheorem(a, b, c);

		System.out.println("The value of a is: " + p.getA());
		System.out.println("The value of b is: " + p.getB());
		System.out.println("The value of c is: " + p.getC());

	}

}
