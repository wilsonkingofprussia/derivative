package derivativecalculator;

import java.lang.Math;
public interface ITerm {
	public ITerm derivative();
	public double evaluate(double number);
	public String toString();
}
