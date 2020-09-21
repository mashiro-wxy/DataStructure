package huffman;

public class HuffmanTree {
    private String charset;
    int n;
    private TriElement[] huftree;

    public HuffmanTree(int[] weights, char[] ch){
        this.charset = "";
        for (int i = 0;i < weights.length; i++){
            this.charset += ch[i];
            //this.huftree[i].code = ch[i];
        }
        n = weights.length;
        this.huftree = new TriElement[2*n-1];
        for (int i = 0;i < n;i++) {
            this.huftree[i] = new TriElement(weights[i]);
            this.huftree[i].code = ch[i];
        }
        for (int i = n;i < 2 * n - 1; i++){
            int min1 = Integer.MAX_VALUE, min2 = min1;
            int x1 = -1, x2 = -1;
            for (int j = 0;j < i;j++)
                if (this.huftree[j].parent == -1)
                    if (this.huftree[j].data < min1){
                        min2 = min1;
                        x2 = x1;
                        min1 = this.huftree[j].data;
                        x1 = j;
                    }
                    else if(this.huftree[j].data < min2){
                        min2 = huftree[j].data;
                        x2 = j;
                    }
                this.huftree[x1].parent = i;
                this.huftree[x2].parent = i;
                this.huftree[i] = new TriElement(min1 + min2, -1, x1, x2);
        }
    }

    private String getCode(int i){
        int n = 8;
        char hufcode[] = new char[n];
        int child = i, parent = this.huftree[child].parent;
        for (i = n - 1;parent != -1; i--){
            hufcode[i] = (huftree[parent].left == child) ? '0' : '1';
            child = parent;
            parent = huftree[child].parent;
        }
        return new String(hufcode, i + 1, n - 1 - i);
    }

    public String toString(){
        /*String str = "Huffman树的结点数组:";
        for (int i = 0; i < this.huftree.length; i++)
            str += this.huftree[i].toString() + ",";*/
    	System.out.println("位置\t字符\t权值\t父节点\t左儿子结点 右儿子结点");
		for(int i = 0; i < 2 * n - 1; i++) {
			System.out.printf(" %d\t %s\t %d\t %d\t %d\t\t%d\n",i, 
					huftree[i].code, huftree[i].data, huftree[i].parent,
					huftree[i].left, huftree[i].right);
		}
		String str = "";
        str += "\nHuffman编码: ";
        for (int i = 0;i < this.charset.length(); i++)
            str += this.charset.charAt(i) + ": " + getCode(i) + ",";
        return str;
    }

    public String encode(String text){
        String compressed = "";
        for (int i = 0;i < text.length(); i++) {
            int j;
            for (j = 0; j < this.charset.length(); j++){
                if (text.charAt(i) == this.charset.charAt(j))
                    break;
            }
            compressed += getCode(j);
        }
        return compressed;
    }

    public String decode(String compressed){
        String text = "";
        int node = this.huftree.length - 1;
        for (int i = 0;i < compressed.length(); i++){
            if (compressed.charAt(i) == '0')
                node = huftree[node].left;
            else
                node = huftree[node].right;
            if (huftree[node].isLeaf()){
                text += this.charset.charAt(node);
                node = this.huftree.length - 1;
            }
        }
        return text;
    }

}
