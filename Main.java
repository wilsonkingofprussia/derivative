package derivativecalculator;

public class Main {
	public static void main(String[] args) {
		
	//Testing ConstantTerm
		System.out.println("ConstantTerm");
		//constructor
		ITerm t1 = new ConstantTerm(5);
		//toString
		System.out.println(t1);
		//evaluate
		System.out.println(t1.evaluate(5));
		System.out.println(t1.evaluate(7));
		//derivative
		System.out.println(t1.derivative());
	//Testing LinearTerm
		System.out.println();
		System.out.println("LinearTerm");
		//constructor
		ITerm t2 = new LinearTerm(2);
		//toString
		System.out.println(t2);
		//evaluate
		System.out.println(t2.evaluate(2));
		System.out.println(t2.evaluate(3));
		//derivative
		System.out.println(t2.derivative());
		
	//Testing PolynomialTerm
		System.out.println();
		System.out.println("PolynomialTerm");
		//constructor
		ITerm t3 = new PolynomialTerm(-4, 3);
		//toString
		System.out.println(t3);
		//evaluate
		System.out.println(t3.evaluate(2));
		System.out.println(t3.evaluate(3));
		//derivative
		System.out.println(t3.derivative());
		
	//Testing TrigTerm
		System.out.println();
		System.out.println("TrigTerm");
		//constructor
		ITerm t4 = new TrigTerm(-6, TrigType.COSINE);
		//toString
		System.out.println(t4);
		//evaluate
		System.out.println(t4.evaluate(90));
		System.out.println(t4.evaluate(45));
		System.out.println(t4.evaluate(0));
		//derivative
		System.out.println(t4.derivative());
		
	//Linked List
		System.out.println();
		System.out.println("ProjLinkedList");
		ProjLinkedList<ITerm> phil = new ProjLinkedList<ITerm>();
		phil.add(t1);
		phil.add(t2);
		phil.add(t3);
		phil.add(t4);
		System.out.println(phil.getAt(0));
		System.out.println(phil.getAt(1));
		System.out.println(phil.getAt(2));
		System.out.println(phil.getAt(3));
		
	//expression
		System.out.println();
		System.out.println("Expression");
		Expression e1 = new Expression();
		e1.add(t2);
		e1.add(t3);
		e1.add(t4);
		System.out.println(e1.toString());
		System.out.println(e1.getEvaluation(0));
		System.out.println(e1.getDerivative());
	}
}