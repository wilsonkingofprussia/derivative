package derivativecalculator;

public class ConstantTerm implements ITerm{
	private int constantNumber;
	//default constructor
	public ConstantTerm(int constantNumber) {
		this.constantNumber = constantNumber;
	}
	public ConstantTerm() {}
	//Next 3 methods are from ITerm interface
	@Override
	public ITerm derivative() {
		ITerm constDer = new ConstantTerm(0);
		return constDer;
	}
	@Override
	public double evaluate(double number) {
		return constantNumber;
	}
	@Override
	public String toString() {
		String output = new String();
		//add signn
		if (constantNumber > 0)
			output += "+ ";
		else if (constantNumber < 0)
			output += "- ";
		output += Math.abs(constantNumber);
		return output;
	}
}
