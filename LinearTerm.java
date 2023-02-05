package derivativecalculator;

public class LinearTerm extends ConstantTerm{
	private int coef;
	//default constructor
	public LinearTerm(int coef) {
		this.coef = coef;
	}
	public LinearTerm() {}
	//Next 3 methods are from ITerm interface
	@Override
	public ITerm derivative() {
		ITerm linearDer = new ConstantTerm(coef);
		return linearDer;
	}
	@Override
	public double evaluate(double number) {
		return coef * number;
	}
	@Override
	public String toString() {
		String output = new String();
		//add sign
		if (coef > 0)
			output += "+ ";
		else if (coef < 0)
			output += "- ";
		output += (Math.abs(coef) + "x");
		return output;
	}
}
