package sparse_matrix;

import PloyList_package.Addible;
import PloyList_package.Polynomial;
import basic_class.Comparable;

public class Triple implements Comparable<Triple>, Addible<Triple> {
	
	public int row,column,value;
	
	/*public Triple() {
		this.row = 0;
		this.column = 0;
		this.value = 0;
	}*/
	
	public Triple(int row, int column, int value) {
		if(row >= 0 && column >= 0) {
			this.row = row;
			this.column = column;
			this.value = value;
		}
		else throw new IllegalArgumentException("行,列号不能为负数: row=" + row + ",column=" + column);
	}
	
	public Triple(Triple tri) {
		this(tri.row, tri.column, tri.value);
	}
	
	public String toString() {
		return "(" + row + "," + column + "," + value + ")";
	}
	

	@Override
	public void add(Triple term) {
		if(this.compareTo(term) == 0)
			this.value += term.value;
		else throw new IllegalArgumentException("两项的指数不同,不能相加");
	}

	@Override
	public boolean removable() {
		return this.value == 0;
	}

	@Override
	public int compareTo(Triple tri) {
		if(this.row == tri.row && this.column == tri.column)
			return 0;
		else return (this.row < tri.row || this.row == tri.row && this.column < tri.column)? -1 : 1; 
	}
	
	public boolean equals(Object obj) {
		return this == obj || obj instanceof Triple 
				&& this.row == ((Triple)obj).row
				&& this.column == ((Triple)obj).column
				&& this.value == ((Triple)obj).value;
	}
	
	public Triple toSymmetry() {
		return new Triple(this.column, this.row, this.value);
	}

}
