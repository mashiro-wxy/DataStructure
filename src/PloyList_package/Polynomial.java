package PloyList_package;

import basic_class.Node;
import basic_class.SortedSinglyList;

public class Polynomial extends SortedSinglyList{
	
	private SortedSinglyList<TermX> list = new SortedSinglyList<>();
	
	public Polynomial() {
		this.list = new SortedSinglyList<TermX>();
	}
	
	public Polynomial(TermX terms[]) {
		int size = terms.length;
		for(int i=0;i<size;i++) {
			if(terms[i].coef == 0)
				continue;
			TermX term = new TermX(terms[i].coef,terms[i].xexp);
			list.insert(term);
		}
	}
	
	public Polynomial(String polystr) {
		this();
		if(polystr == null || polystr.length() == 0)
			return;
		Node<TermX> rear = this.list.head;
		int start=0, end=0;
		while (start < polystr.length() && end < polystr.length()) {
			int i = polystr.indexOf('+',end+1);
			if(i == -1)
				i = polystr.length();
			int j = polystr.indexOf('-',end+1);
			if(j ==-1)
				j = polystr.length();
			end = i < j ? i : j;
			rear.next = new Node<TermX>(new TermX(polystr.substring(start,end)),null);
			rear = rear.next;
			start = end;
		}
	}
	
	
	public Polynomial(Polynomial poly) {
		this();
		Node<TermX> p = poly.list.head.next;
		Node<TermX> rear = this.list.head;
		while(p != null) {
			rear.next = new Node<TermX>(new TermX(p.data),null);
			rear = rear.next;
			p = p.next;
		}
		/*int size = poly.list.size();
		TermX terms[] = new TermX[size];
		for(int i=0; i<size;i++) {
			terms[i].coef = poly.list.get(i).coef;
			terms[i].xexp = poly.list.get(i).xexp;
			if(terms[i].coef == 0)
				continue;
			TermX term = new TermX(terms[i].coef,terms[i].xexp);
			list.insert(term);
		}*/
	}
	
	public String toString() {
		String s = "";
		for(Node<TermX> p = this.list.head.next; p != null; p = p.next)
			s += p.data.toString();
		return s;
	}
	
	public void addAll(Polynomial poly) {
		int i,j;
		for(i = 0, j = 0;i < list.size() && j < poly.list.size();) {
			TermX l = (TermX) list.get(i);
			TermX r = (TermX) poly.list.get(j);
			if(l.compareTo(r) == 0) {
				l.setCoef(l.getCoef() + r.getCoef());
				if(l.getCoef() == 0)
					list.remove(i);
				j++;
			}else if(l.compareTo(r) < 0) {
				i++;
			}else {
				TermX tmp = new TermX(r.getCoef(), r.getXexp());
				list.insert(tmp);
				i++;
				j++;
			}
		}
		while(j < poly.list.size()) {
			TermX tmp = (TermX) poly.list.get(j);
			list.insert(new TermX(tmp.getCoef(), tmp.getXexp()));
			j++;
		}

	}
	
	public Polynomial union(Polynomial poly) {
		Polynomial cpoly = new Polynomial(this);
		cpoly.addAll(poly);
		return cpoly;
	}
	
	public boolean equals(Object obj) {
		return this == obj || obj instanceof Polynomial 
				&& this.list.equals(((Polynomial)obj).list);
	}
	
}
