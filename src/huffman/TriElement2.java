package huffman;

public class TriElement2 {
	/*int parent,left,right,weight;//结点权值;
	String name;//结点数据,存放字符名称
	String code;//存放叶子结点字符编码*/
	private int weight; //结点权值
	private int lchild; //左孩子结点
	private int rchild; //右孩子结点
	private int parent; //父结点
	private String name;	//结点数据,存放字符名称
	private String code;//存放叶子结点的字符编码
	
	public TriElement2(String name, int w) {
		this.weight = w;
		this.name = name;
		this.parent = -1;
		this.lchild = -1;
		this.rchild = -1;
		this.code = "";
	}
	
	public TriElement2() {
		this(null,0);
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getLchild() {
		return lchild;
	}
	public void setLchild(int lchild) {
		this.lchild = lchild;
	}
	public int getRchild() {
		return rchild;
	}
	public void setRchild(int rchild) {
		this.rchild = rchild;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
