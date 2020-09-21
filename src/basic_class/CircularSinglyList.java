package basic_class;

public class CircularSinglyList<T> extends Object {
	public Node<T> head;
	protected int n=0;
	protected Object[] element;
	
	public CircularSinglyList() {
		this.head = new Node<T>();
		head.next = head;
	}
	
	public CircularSinglyList(T[] values) {
		this();
		Node<T> rear = this.head;
		for(int i=0; i < values.length; i++) {
			rear.next = new Node<T>(values[i], null);
			rear = rear.next;
		}
		rear.next = head;
	}
	
	public boolean isEmpty() {
		return this.head.next == head;
	}
	
	public T get(int i) {
		Node<T> p = head.next;
		for(int j = 0; p != head && j < i; j++) {
			p = p.next;
		}
		return (i >= 0 && p != head)? p.data : null;
	}
	
	
	public void set(int i,T x) {
		if(x==null)
			throw new NullPointerException("x==null");
		if(i>=0 && i<this.n)
			this.element[i]=x;
		else throw new IndexOutOfBoundsException(i+"");
	}
	
	public int size() {
		n=0;
		Node<T> p = head;
		while(p.next!=head) {
			n++;
			p = p.next;
		}
		return n;
	}
	
	public String toString() {
		String str = "CircularSinglyList(";
		for(Node<T> p = this.head.next; p != head; p = p.next) {
			str += p.data.toString();
			if(p.next != head)
				str += ",";
		}
		return str + ")";
	}
	
	public Node<T> insert(int i, T x){
		if(x == null)
			throw new NullPointerException("x == null");
		Node<T> front = this.head;
		for(int j=0; front.next != head && j<i; j++)
			front = front.next;
		front.next = new Node<T>(x, front.next);
		return front.next;
	}
	
	
	public T remove(int i) {
		Node<T> p = this.head;
		for(int j=0;j<i;j++) {
			p=p.next;
		}
		if(p.next == head)
			p=p.next;
		if(i>=0 && p.next != head) {
			T old = p.next.data;
			p.next = p.next.next;
			return old;
		}
		return null;
		/*Node<T> front = this.head;
		for(int j=0; front.next != head && j<i; j++)
			front = front.next;
		if(i>=0 && front.next != null) {
			T old = front.next.data;
			front.next = front.next.next;
			return old;
		}
		return null;*/
	}
	
	public int search(T key) {
		Node<T> p;
		int i=0;
		for(p=head.next;p!=head;p=p.next,i++) {
			if(key.equals(p.data)) {
				return i;
			}
		}
		return -1;
	}
	
}
