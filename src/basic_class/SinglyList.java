package basic_class;

public class SinglyList<T> extends Object{
	
	public Node<T> head;
	protected int n=0;
	
	public SinglyList() {
		this.head = new Node<T>();
	}
	//尾插入创建
	public SinglyList(T[] values) {
		this();
		Node<T> rear = this.head;
		for(int i=0; i < values.length; i++) {
			rear.next = new Node<T>(values[i], null);
			rear = rear.next;
		}
	}
	/*//头插入创建
	public SinglyList(T[] values) {
		this.head = new Node<T>();
		for(int i=0; i < values.length; i++) {
			head.next = new Node<T>(values[i], head.next);
		}
	}*/
	
	public boolean isEmpty() {
		return this.head.next == null;
	}
	
	public T get(int i) {
		Node<T> p = this.head.next;
		for(int j = 0; p != null && j < i; j++) {
			p = p.next;
		}
		return (i >= 0 && p != null)? p.data : null;
	}
	
	
	public void set(int i,T x) {
		if(x==null)
			throw new NullPointerException("x==null");
		if(i>=0) {
			Node<T> p = this.head.next;
			for(int j = 0; p != null && j < i; j++) {
				p = p.next;
			}
			p.data=x;
		}
		else throw new IndexOutOfBoundsException(i+"");
	}
	
	public int size() {
		n=0;
		Node<T> p = head;
		while(p.next!=null) {
			n++;
			p = p.next;
		}
		return n;
	}
	
	public String toString() {
		String str = "SinglyList(";
		for(Node<T> p = this.head.next; p != null; p = p.next) {
			str += p.data.toString();
			if(p.next != null)
				str += ",";
		}
		return str + ")";
	}
	
	public Node<T> insert(int i, T x){
		if(x == null)
			throw new NullPointerException("x == null");
		Node<T> front = this.head;
		for(int j=0; front.next != null && j<i; j++)
			front = front.next;
		front.next = new Node<T>(x, front.next);
		return front.next;
	}
	
	public Node<T> insert(T x){
		return insert(Integer.MAX_VALUE, x);
	}
	
	public T remove(int i) {
		Node<T> front = this.head;
		for(int j=0; front.next != null && j<i; j++)
			front = front .next;
		if(i>=0 && front.next != null) {
			T old = front.next.data;
			front.next = front.next.next;
			
			return old;
		}
		return null;
	}
	
	public void clear() {
		this.head.next = null;
	}
	
	/*public int search(T key) {
		Node<T> p;
		int i=0;
		for(p=head.next;p!=null;p=p.next,i++) {
			if(key.equals(p.data)) {
				return i;
			}
		}
		return -1;
	}*/
	
	public Node<T> search(T key) {
		Node<T> p;
		for(p=head.next;p!=null;p=p.next) {
			if(key.equals(p.data)) {
				return p;
			}
		}
		return null;
	}
	
	
	/*
	public boolean contains(T key) {
		return this.search(key).equals();
	}*/
	
	public T remove(T key) {
		Node n;
		Node last = head;
		for(n = head; n != null; n = n.next) {
			if(key.equals(n)) {
				n=n.next;
				break;
			}
		}
		return null;
	}
	
	public SinglyList(SinglyList<T> list) {
		this.head = list.head;
	}
	
	public void reverse(SinglyList<T> list) {
		if(list.head == null || list.head.next == null) {
			throw new NullPointerException("head==null");
		}
		Node<T> front=list.head.next;
		Node<T> cur = list.head.next.next;
		
		while(cur != null) {
			Node<T> tmp = cur.next;
			cur.next = front;
			front = cur;
			cur = tmp;
		}
		list.head.next.next = null;
		
		this.head.next = front;
	}
	
	public void reverse2(SinglyList<T> list) {
		Node<T> oldP = list.head.next;
		Node<T> newP = null;
		while(oldP != null) {
			Node<T> p = oldP.next;
			oldP.next = newP;
			newP=oldP;
			oldP=p;
		}
		this.head.next = newP;
	}

}
