package derivativecalculator;

public class Expression {
	//default constructor
	public Expression() {}
	ProjLinkedList<ITerm> termsList = new ProjLinkedList<ITerm>();
	public Expression getDerivative() {
		//create new expression for derivative. traverse old linked list, calc derivative. add them to new linked list. 
		Expression derExpression = new Expression();
		derExpression.termsList = termsList;
		ProjNode<ITerm> currNode = derExpression.termsList.head;
		while(currNode != null) {
			currNode.data = currNode.data.derivative();
			currNode = currNode.next;
		}
		return derExpression;
	}
	public double getEvaluation(double number) {
		//traverse linked list, calculating each term and adding it to the sum
		double sum = 0;
		for (int i=0; i < termsList.getSize(); i++) {
			sum += termsList.getAt(i).evaluate(number);
		}
		return sum;
	}
	public int getTypePriority(ProjNode<ITerm> currNode) { //assign number to term type based on priority
		int typePriority = 0;
		if (currNode.data instanceof TrigTerm)
			typePriority = 4;
		else if (currNode.data instanceof LinearTerm)
			typePriority = 2;
		else if (currNode.data instanceof ConstantTerm)
			typePriority = 3;
		else if (currNode.data instanceof PolynomialTerm)
			typePriority = 1;
		return typePriority;
	}
	public void sort() { //bubble sort
		ProjNode<ITerm> currNode = termsList.head;
		ProjNode<ITerm> nextNode = null;
		ITerm tempData = null;
		int currTypePriority = 0;
		int nextTypePriority = 0;
		if (currNode == null) { //if the list is empty, its already sorted
			return;
		} //sort the list:
		while (currNode != null) { //currNode starts at head, nextNode starts at the next one
			nextNode = currNode.next; //nextNode traverses list, comparing the contents to currNode
			while (nextNode != null) { //every time it finishes, currNode moves up one, and nextNode traverses the list again from a more advanced position
				currTypePriority = getTypePriority(currNode);
				nextTypePriority = getTypePriority(nextNode);
				if (currTypePriority > nextTypePriority) { //compare priorities of terms
					tempData = currNode.data; //if the next term has a higher priority, swap
					currNode.setData(nextNode.data);
					nextNode.setData(tempData);
				}
				nextNode = nextNode.next;
			}
			currNode = currNode.next;
		}
	}
	@Override
	public String toString() {
		//sort linked list, then traversing it adding each term's toString output to final
		String output = new String();
		sort();
		ProjNode<ITerm> currNode = termsList.head;
		while (currNode != null) {
			ITerm data = currNode.data;
			output += data.toString();
			currNode = currNode.next;
			output += " ";
		}
		return output;
	}
	public void add(ITerm term) {termsList.add(term);}
}
