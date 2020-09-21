package basic_class;

public class SortedSinglyList<T extends Comparable<? super T>> extends SinglyList<T>{

	public SortedSinglyList() {
		super();
	}
	
	public SortedSinglyList(SortedSinglyList<T> list) {
		super(list);
	}
	
	public SortedSinglyList(SinglyList<T> list) {
		super();
		for(Node<T> p = list.head.next; p != null; p = p.next)
			this.insert(p.data);
	}
	
	public void set(int i,T x) {
		throw new UnsupportedOperationException("set(int i,T x)");
	}
	public Node insert(int i,T x) {
		throw new UnsupportedOperationException("insert(int i,T x)");
	}
	
	public Node<T> insert(T x){
		Node<T> front = this.head, p = front.next;
		while(p != null && x.compareTo(p.data) > 0) {
			front = p;
			p = p.next;
		}
		front.next = new Node<T>(x,p);
		return front.next;
	}
	
	
	
}
