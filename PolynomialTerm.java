package derivativecalculator;

public class PolynomialTerm extends LinearTerm{
	private int coef;
	private int exponent;
	//default constructor
	public PolynomialTerm(int coef, int exponent) {
		this.coef = coef;
		this.exponent = exponent;
	}
	//Next 3 methods are from ITerm interface
	@Override
	public ITerm derivative() {
		if (exponent == 2) {
			ITerm polyDer = new LinearTerm(coef * 2);
			return polyDer;
		}
		else {
			ITerm polyDer = new PolynomialTerm(coef * exponent, exponent - 1);
			return polyDer;
		}
	}
	@Override
	public double evaluate(double number) {
		return coef * Math.pow(number, exponent);
	}
	@Override
	public String toString() {
		String output = new String();
		//add sign
		if (coef > 0)
			output += "+ ";
		else if (coef < 0)
			output += "- ";
		output += (Math.abs(coef) + "x^" + exponent);
		return output;
	}
}
