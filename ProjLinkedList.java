package derivativecalculator;

public class ProjLinkedList <S> {
	public ProjNode<S> head;
	private int size = 0;
	public void add(S data) { //prepend
		ProjNode<S> newNode = new ProjNode<S>(data);
		if (head != null) {
			newNode.setNext(head);
		}
		head = newNode;
		size++;
	}
	public S getAt(int position) { //get data with position
		ProjNode<S> currNode = head;
		for (int i = 0; i < position; i++) {
			currNode = currNode.next;
		}
		return currNode.data;
	}	
	public int getSize() {return size;} //access size
}
