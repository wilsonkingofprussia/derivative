package derivativecalculator;

public class TrigTerm extends LinearTerm{
	private int coef;
	private TrigType operation;
	//default constructor
	public TrigTerm(int coef, TrigType operation) {
		this.coef = coef;
		this.operation = operation;
	}
	//Next 3 methods are from ITerm interface
	@Override
	public ITerm derivative() {
		ITerm trigDer = null;
		switch(operation) {
			case SINE: {
				trigDer = new TrigTerm(coef, TrigType.COSINE);
				break;
			}
			case COSINE: {
				trigDer = new TrigTerm(-coef, TrigType.SINE);
				break;
			}
		}
		return trigDer;
	}
	@Override
	public double evaluate(double number) {
		double evaluation = 0;
		number = Math.toRadians(number);
		switch(operation) {
			case SINE: {
				evaluation = coef * Math.sin(number);
				break; }
			case COSINE: {
				evaluation = coef * Math.cos(number);
				break; }
		}
		return evaluation;
	}
	@Override
	public String toString() {
		String output = new String();
		//add sign
		if (coef > 0)
			output += "+ ";
		else if (coef < 0)
			output += "- ";
		output += Math.abs(coef);
		switch(operation) {
			case SINE: {
				output += "sin(x)";
				break; }
			case COSINE: {
				output += "cos(x)";
				break; }
		}
		return output;
	}	
}
