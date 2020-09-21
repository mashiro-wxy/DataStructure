package mazeSolution;

import basic_class.SeqList;

public final class SeqStack<T> implements Stack<T> {

	public  SeqList<T> list;
	//private int top;
	public SeqStack(int length) {
		this.list = new SeqList<T>(length);
		//top = -1;
	}
	public SeqStack() {
		this(64);
	}
	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public void push(T x) {
		this.list.insert(x);
		//list.element[++top] = x;
	}

	@Override
	public T peek() {
		return this.list.get(list.size()-1);
	}

	@Override
	public T pop() {
		return list.remove(list.size()-1);
	}

}
