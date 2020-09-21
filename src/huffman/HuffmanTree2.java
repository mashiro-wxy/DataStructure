/*
package huffman;

import java.util.LinkedList;
import java.util.Queue;

public class HuffmanTree2 {
	private int leafNum;//叶子结点数
	private TriElement2[] huftree;//结点数组
	String charset;
	
	public void create(String str) {
		int[] c = new int[26];
		for(int i = 0; i < str.length(); i++) {//统计个字符出现的频率
			c[str.charAt(i) - 'a']++;
		}
		int cnt = 0;
		for(int i = 0; i < 26; i++) {//统计字符种类数量
			if(c[i] > 0)
				cnt++;
		}
		this.leafNum = cnt;
		huftree = new TriElement2[this.leafNum * 2 - 1];
		for(int i = 0; i < 2 * leafNum - 1; i++)
			huftree[i] = new TriElement2();
		cnt = 0;
		for(int i = 0; i < 26; i++) {//创建叶子结点
			if(c[i] > 0) {
				huftree[cnt].name = (char)(i + 'a') + "";
				huftree[cnt++].weight = c[i];
			}
		}
		
		//建立哈夫曼树
		for(int i = 0; i < this.leafNum - 1; i++) {
			int min1 = Integer.MAX_VALUE,min2 = min1;//m1最小权值,min2次小权值
			int x1 = 0, x2 = 0;//x1权值最小位置,x2权值次小位置
			for(int j = 0; j < this.leafNum + i; j++) {
				if((huftree[j].weight < min1) && (huftree[j].parent == -1)) {
					min2 = min1;
					x2 = x1;
					min1 = huftree[j].weight;
					x1 = j;
				}
				else if((huftree[j].weight < min2) && (huftree[j].parent == -1)) {
					min2 = huftree[j].weight;
					x2 = j;
				}
			}
			huftree[this.leafNum +i].weight = huftree[x1].weight + huftree[x2].weight;
			huftree[this.leafNum + i].left = x1;
			huftree[this.leafNum + i].right = x2;
			huftree[x1].parent = i;
			huftree[x2].parent = i;
		}
	}
	
	*/
/*private String getCode(int i){
        int n = 8;
        char hufcode[] = new char[n];
        int child = i, parent = this.huftree[child].parent;
        for (i = n - 1;parent != -1; i--){
            hufcode[i] = (huftree[parent].left == child) ? '0' : '1';
            child = parent;
            parent = huftree[child].parent;
        }
        return new String(hufcode, i + 1, n - 1 - i);
    }*//*

	
	
	
	public void print() {
		System.out.println("位置\t字符\t权值\t父节点\t左儿子结点 右儿子结点");
		for(int i = 0; i < 2 * leafNum - 1; i++) {
			System.out.printf(" %d\t %s\t %d\t %d\t %d\t\t%d\n",i, 
					huftree[i].name, huftree[i].weight, huftree[i].parent,
					huftree[i].left, huftree[i].right);
		}
	}
	
	public int encode(TriElement2 root, String code) {
		int sum = 0;
		
		if(root != null) {
			root.code = code;
			if(root != null && root.isLeaf()) {
				System.out.println(root.name + ":" + root.code);
				return root.weight * root.code.length();
			}
			if(root.left != -1) {
				//左子树,编码为0,并统计左子树叶子结点的长度
				sum += encode(huftree[root.left], code + "0");
			}
			if(root.right != -1) {
				//右子树,编码为1,并统计右子树叶子结点的长度
				sum += encode(huftree[root.right], code + "1");
			}
		}
		return sum;
	}
		
	
	public String decodes(String codes){
		//根结点的位置
		int root = 2*leafNum-2;
		// 根结点为空
		if (root == -1) {
			return "";
		}
		// 设置一个队列保存层序遍历的结点
		Queue<TriElement2> q = new LinkedList<TriElement2>();
		// 根结点入队
		q.add(huftree[root]);	
		int i = 0;
		String str = "";
		// 队列非空，结点没有处理完
		while (!q.isEmpty()) {
			// 结点出队
			TriElement2 tmp = q.poll();
			if(!codes.startsWith(tmp.code)) continue;
			// 如果是叶子结点，则计算编码长度
			if(tmp.isLeaf()){
				str = str + tmp.name;
				codes = codes.substring(tmp.code.length());
				if(codes.length()>0){ //如果存在多个报文字符，则继续重新解码
					while(!q.isEmpty()) q.poll();
					q.add(huftree[root]);	
					continue;
				}
			}
			// 将当前结点的左孩子结点入队
			if (tmp.left != -1) {
				q.add(huftree[tmp.left]);				
			}
			if (tmp.right != -1) {
				// 将当前结点的右孩子结点入队
				q.add(huftree[tmp.right]);				
			}
		}
		return str;
	}
	
	public String traverse(String text) {
		int root = 2 * leafNum -2;
		if(root == -1) {
			return "";
		}
		int sum = encode(huftree[root], "");
		System.out.println("编码长度" + sum + "位");	
		String s = "";
		for(int i=0; i < text.length(); i++) {
			s += getCode(text.charAt(i)-'a');
		}
		return s;
	}
}
*/
