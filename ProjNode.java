package derivativecalculator;

public class ProjNode<T> {
	public T data;
	public ProjNode<T> next;
	public ProjNode(T data){
		this.data = data;
		next = null;
	}
	public void setNext(ProjNode<T> next) { this.next = next; }
	public void setData(T data) {this.data = data; }
}
