package sparse_matrix;

import basic_class.Node;
import basic_class.SeqList;


public class SeqMatrix {
	private int rows,cols,t;
	SeqList<Triple> list;
	
	public SeqMatrix(int m,int n,int t) {
		if(m > 0 && n > 0) {
			this.rows = m;
			this.cols = n;
			this.t = t;
			this.list = new SeqList<Triple>();
			for(int i = 0; i < 10; i++) {
				this.list.insert(new Triple(0,0,0));
			}
		}
		else throw new IllegalArgumentException("矩阵行列数不能小于等于0, m=" + m + ",n=" + n);
	}
	
	/*public SeqMatrix(int m) {
		this(m, m);
	}*/
	
	public SeqMatrix(int m, int n, Triple[] tris) {
		list = new SeqList<Triple>();
		for(int i = 0; i < tris.length; i++) {
			list.insert(tris[i]);
			t++;
		}
		this.rows = m;
		this.cols = n;
	}
	
	public int getRows() {
		return this.rows;
	}
	
	public int getColumns() {
		return this.cols;
	}
	
	public void set(int row, int col, int val) {
		if(val == 0)
			return;
		if(row >= this.rows || col >= this.cols)
			throw new IllegalArgumentException("三元组的行或列序号越界");
		Triple elem = new Triple(row, col, val);
		int i = 0;
		while(i < this.list.size()) {
			Triple item = this.list.get(i);
			if(elem.compareTo(item) == 0) {
				this.list.set(i, elem);
				return;
			}
			if(elem.compareTo(item) >= 0)
				i++;
			else
				break;
		}
		this.list.insert(i,elem);
	}
	
	public void set(Triple tri) {
		this.set(tri.row, tri.column, tri.value);
	}
	
	public int get(int i, int j) {
		if(i >= 0 && i < this.rows && j >= 0 && j < this.cols) {
			Triple item = new Triple(i, j, 0);
			int k = 0;
			Triple elem = this.list.get(k);
			while(k < this.list.size() && item.compareTo(elem) >= 0) {
				if(item.compareTo(elem) == 0)
					return elem.value;
				k++;
				elem = this.list.get(k);
			}
			return 0;
		}
		throw new IndexOutOfBoundsException("i=" + i + ", j=" + j);
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i < this.list.size(); i++)
			str += i + " " + this.list.get(i).toString() + "\n";
		return str;
	}
	
	public void printMatrix() {
		System.out.println("矩阵SeqMatrix" + "(" + rows + "x" + cols +"): ");
		int k=0;
		Triple elem = this.list.get(k++);
		for(int i = 0; i < this.list.size(); i++) {
			for(int j = 0; j < this.cols; j++)
				if(elem != null && i == elem.row && j == elem.column) {
					System.out.print(String.format("%4d", elem.value) );
					elem = this.list.get(k++);
				}
				else System.out.print(String.format("%4d", 0));
			System.out.println();
		}
	}
	
	
	public SeqMatrix transpose() {
		//构造0矩阵,指定行数列数
		SeqMatrix trans = new SeqMatrix(cols, rows, t);
		for(int i = 0; i < this.list.size(); i++) {
			//插入矩阵对称位置元素的三元组
			trans.set(this.list.get(i).toSymmetry());
		}
		return trans;
	}
	
	public SeqMatrix FastTranspose(SeqMatrix M, SeqMatrix T) {
		int num[] = new int[cols+1];//M中第col列中非零元的个数
		int mu,nu,tu;
		for(nu = 0; nu < cols; nu++)
			num[nu] = 0;
		for(tu = 0; tu < t; tu++)
			num[M.list.get(tu).column]++;
		int cpot[] = new int[cols+1];//M中第col列的第一个非零元在T.data中的位置
		cpot[0] = 1;
		for(nu = 1; nu < cols; nu++)
			cpot[nu] = cpot[nu-1] + num[nu-1];
		int p,q;
		//实现转置
		for(p = 0; p < t; p++) {
			nu = M.list.get(p).column;
			q = cpot[nu];
			T.list.get(q).row = M.list.get(p).column;
			T.list.get(q).column = M.list.get(p).row;
			T.list.get(q).value = M.list.get(p).value;
			cpot[nu]++;
		}
		
		return T;
	}
	
	/*public void addAll(LinkedMatrix mat) {
		if(this.rows == mat.rows && this.columns == mat.columns)
			for(int i = 0; i < this.rows; i++)
				this.rowlist.get(i).addAll(mat.rowlist.get(i));
		else throw new IllegalArgumentException("两个矩阵阶数不同,不能相加");
	}*/
}

