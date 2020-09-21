package huffman;

import java.util.Scanner;
public class test {

	static int[] a = new int[30];
    static char[] b = new char[30];
    private static int[] turnWeight(String text){
        int n = 0, m = 0, j = 0;
        for (int i = 0; i < text.length(); i++){
            m = 0;
            for(j = 0; b[j] != 0; j++){
                if (b[j] == text.charAt(i)){
                    m = 1;
                    break;
                }
            }
            if (m == 0){
                b[n] = text.charAt(i);
                a[n] = 1;
                n++;
            }else {
                a[j] += 1;
            }
        }
        selectSort(n);
        int[] weight = new int[n];
        for (int i = 0; i < n; i++)
            weight[i] = a[i];
        return weight;
    }
    static void selectSort(int n)
    {
        for (int i = 0; i < n; ++i)
        {
            int minIndex = i;
            for (int j = i + 1; j < n; ++j)
            {
                if (a[j] > a[minIndex])
                    minIndex = j;
            }
            if (minIndex != i){
                int g = a[i];
                a[i] = a[minIndex];
                a[minIndex] = g;
                char c = b[i];
                b[i] = b[minIndex];
                b[minIndex] = c;
            }

        }
    }
    public static void main(String[] args){
        String text;
        System.out.println("输入一串字符：");
        Scanner sn = new Scanner(System.in);
        text = sn.next();
        HuffmanTree huffman = new HuffmanTree(turnWeight(text), b);
        System.out.println(huffman.toString());
        
        String compressed = huffman.encode(text);
        System.out.println("将" + text + "压缩为" + compressed + "," + compressed.length() + "位");
        System.out.println("将" + compressed + "解码为" + huffman.decode(compressed));
    }
}