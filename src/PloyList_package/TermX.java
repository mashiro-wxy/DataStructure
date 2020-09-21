package PloyList_package;
import basic_class.Comparable;
import basic_class.Node;

public class TermX implements Comparable<TermX>,Addible<TermX> {

	protected int coef,xexp;
	
	public TermX(int coef, int xexp) {
		this.coef = coef;
		this.xexp = xexp;
	}
	
	public TermX(String termstr) {
		if(termstr.charAt(0) == '+')
			termstr = termstr.substring(1);
		int i = termstr.indexOf('x');
		if(i == -1) {
			this.coef = Integer.parseInt(termstr);
			this.xexp = 0;
		}else {
			if(i == 0) {
				this.coef = 1;
			}else {
				String sub = termstr.substring(0,i);
				if(sub.equals("-"))
					this.coef = -1;
				else 
					this.coef = Integer.parseInt(sub);
			}
			i = termstr.indexOf('^');
			if(i == -1)
				this.xexp = 1;
			else 
				this.xexp = Integer.parseInt(termstr.substring(i+1));
		}
		
	}
	
	public TermX(TermX term) {
		this(term.coef, term.xexp);
	}
	
	public void setCoef(int coef) {
		this.coef = coef;
	}
	
	public void setXexp(int xexp) {
		this.xexp = xexp;
	}
	
	public int getCoef() {
		return coef;
	}
	public int getXexp() {
		return xexp;
	}
	
	@Override
	public String toString() {
		String str = this.coef > 0 ? "+" : "-";
		if(this.xexp == 0 || this.xexp > 0 && this.coef != 1 && this.coef != -1)
			str += Math.abs(this.coef);
		if(this.xexp > 0)
			str += "x";
		if(this.xexp > 1) 
			str += "^" + this.xexp;
		return str;
	}
	
	public boolean equals(Object obj) {
		//return this == obj || (obj instanceof TermX) && this.coef == ((TermX)obj).coef && this.xexp == ((TermX)obj).xexp;
		if(this == obj)
			return true;
		if(!(obj instanceof TermX))
			return false;
		TermX term = (TermX) obj;
		return this.coef == term.coef && this.xexp == term.xexp;
	}
	
	@Override
	public void add(TermX t) {
		if(this.compareTo(t) == 0)
			this.coef += t.coef;
		else
			throw new IllegalArgumentException("指数不同,不能相加");
	}

	@Override
	public boolean removable() {
		return this.coef == 0;
	}

	@Override
	public int compareTo(TermX t) {
		if(this.xexp < t.xexp) 
			return -1;
		else if(this.xexp > t.xexp)
			return 1;
		else return 0;
	}

}
