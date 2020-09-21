package huffman;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class HuffmanTree3 {
    private TriElement2[] data; // 结点数组
    private int leafNum; // 叶子结点数目

    public void create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String str = sc.nextLine().toLowerCase();
        int[] c = new int[26];
        for (int i = 0; i < str.length(); i++) { // 统计各字符出现的频率
            c[str.charAt(i) - 'a']++;
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) { // 统计字符的数量
            if (c[i] > 0)
                cnt++;
        }
        this.leafNum = cnt;

        data = new TriElement2[this.leafNum * 2 - 1];
        for (int i = 0; i < 2 * leafNum - 1; i++)
            data[i] = new TriElement2();

        cnt = 0;
        for (int i = 0; i < 26; i++) { // 用字符创建叶子结点
            if (c[i] > 0) {
                data[cnt].setName((char) (i + 'a') + "");
                data[cnt++].setWeight(c[i]);
            }
        }
        int m1, m2, x1, x2;
        // 处理n个叶子结点，建立哈夫曼树
        for (int i = 0; i < this.leafNum - 1; ++i) {
            m1 = m2 = Integer.MAX_VALUE; // m1：最小权值,m2:次小权值
            x1 = x2 = 0; // x1：权值最小位置,x2:权值次小位置
            // 在全部结点中找权值最小的两个结点
            for (int j = 0; j < this.leafNum + i; ++j) {
                if ((data[j].getWeight() < m1) && (data[j].getParent() == -1)) {
                    m2 = m1;
                    x2 = x1;
                    m1 = data[j].getWeight();
                    x1 = j;
                } else if ((data[j].getWeight() < m2)
                        && (data[j].getParent() == -1)) {
                    m2 = data[j].getWeight();
                    x2 = j;
                }
            }
            // 用两个权值最小点构造一个新的中间结点
            data[this.leafNum + i].setWeight(data[x1].getWeight()
                    + data[x2].getWeight());
            data[this.leafNum + i].setLchild(x1);
            data[this.leafNum + i].setRchild(x2);
            // 修改权值最小的两个结点的父结点指向
            data[x1].setParent(this.leafNum + i);
            data[x2].setParent(this.leafNum + i);
        }
    }

    public void print() {
        System.out.println("位置\t字符\t权值\t父结点\t左孩子结点 右孩子结点");
        for (int i = 0; i < 2 * leafNum - 1; i++) {
            System.out.printf("%d\t %s\t %d\t %d\t %d\t %d\n", i,
                    data[i].getName(), data[i].getWeight(),
                    data[i].getParent(), data[i].getLchild(),
                    data[i].getRchild());
        }
    }

    private int preorder(TriElement2 root,String code) {
        int sum = 0;
        if (root != null) {
            root.setCode(code);
            if(isLeaf(root)){		//叶子结点，输出编码，并计算长度
                System.out.println(root.getName() + ":" + root.getCode());
                return root.getWeight()*root.getCode().length();
            }

            if(root.getLchild()!=-1){
                //左子树，编码为0
                sum +=preorder(data[root.getLchild()],code+"0");
            }
            if(root.getRchild()!=-1){
                //右子树，编码为1
                sum +=preorder(data[root.getRchild()],code+"1");
            }
        }
        return sum;
    }

    /*private String getCode(int i){
        int n = leafNum;
        char hufcode[] = new char[n];
        int child = i, parent = this.data[child].getParent();
        for (i = n - 1;parent != -1; i--){
            hufcode[i] = (data[parent].getLchild() == child) ? '0' : '1';
            child = parent;
            parent = data[child].getParent();
        }
        return new String(hufcode, i + 1, n - 1 - i);
    }*/


    public String decodes(String codes){
        //根结点的位置
        int root = 2*leafNum-2;
        // 根结点为空
        if (root == -1) {
            return "";
        }
        Queue<TriElement2> q = new LinkedList<TriElement2>();
        // 根结点入队
        q.add(data[root]);
        int i = 0;
        String str = "";
        while (!q.isEmpty()) {
            TriElement2 tmp = q.poll();
            if(!codes.startsWith(tmp.getCode())) continue;
            if(isLeaf(tmp)){
                str = str + tmp.getName();
                codes = codes.substring(tmp.getCode().length());
                if(codes.length()>0){ //如果存在多个字符，则继续重新解码
                    while(!q.isEmpty()) q.poll();
                    q.add(data[root]);
                    continue;
                }
            }
            if (tmp.getLchild() != -1) {
                q.add(data[tmp.getLchild()]);
            }
            if (tmp.getRchild() != -1) {
                // 将当前结点的右孩子结点入队
                q.add(data[tmp.getRchild()]);
            }
        }
        return str;
    }

    public void traverse() {
        //根结点的位置
        int root = 2*leafNum-2;
        // 根结点为空
        if (root == -1) {
            return;
        }
        int sum = preorder(data[root],"");
        System.out.println("所有编码长度为（位）："+sum);
        /*String compressed = "";
        for (int i = 0; i < text.length(); i++){
            compressed += getCode(text.charAt(i) - 'a');
        }
        return compressed;*/
    }

    // 判断是否是叶子结点
    public boolean isLeaf(TriElement2 p) {
        return ((p != null) && (p.getLchild() == -1) && (p.getRchild() == -1));
    }
}
