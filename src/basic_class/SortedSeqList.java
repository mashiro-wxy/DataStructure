package basic_class;

public class SortedSeqList<T extends Comparable2<? super T>> extends SeqList<T> {
	public SortedSeqList() {
		super();
	}
	public SortedSeqList(int length) {
		super(length);
	}
	public SortedSeqList(T[] values) {
		super(values.length);
		for(int i=0;i<values.length;i++)
			this.insert(values[i]);
	}
	public int insert(T x) {
		int i=0;
		if(this.isEmpty() || x.compareToByTime(this.get(this.size()-1))>0)
			i=this.n;
		else
			while(i<this.n && x.compareToByTime(this.get(i))>0)
				i++;
		super.insert(i,x);
		return i;
	}

	public int insertByTime(T x) {
		int i=0;
		if(this.isEmpty() || x.compareToByTime(this.get(this.size()-1))>0)
			i=this.n;
		else
			while(i<this.n && x.compareToByTime(this.get(i))>0)
				i++;
		super.insert(i,x);
		return i;
	}

	public int insertByName(T x) {
		int i=0;
		if(this.isEmpty() || x.compareToByName(this.get(this.size()-1))>0)
			i=this.n;
		else
			while(i<this.n && x.compareToByName(this.get(i))>0)
				i++;
		super.insert(i,x);
		return i;
	}

	/*public int insertDifferent(T x) {
		return 0;
	}*/
	public void set(int i,T x) {
		throw new UnsupportedOperationException("set(int i,T x)");
	}
	public int insert(int i,T x) {
		throw new UnsupportedOperationException("insert(int i,T x)");
	}
	
	public int search2(T key) {
		for(int i = 0;i < this.n && key.compareToByTime(this.get(i)) >= 0; i++)
			if(key.compareToByTime(this.get(i))==0)
				return i;
		return -1;
	}
	public T remove2(T key) {
		return this.remove(this.search2(key));
	}


	
}
