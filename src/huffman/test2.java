package huffman;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        /*System.out.println("输入一串字符：");
        Scanner sn = new Scanner(System.in);
         String text = sn.next();*/
        HuffmanTree3 h = new HuffmanTree3();
        h.create();
        h.print();
        h.traverse();
        System.out.println("请输入编码进行解码:");
        Scanner sc = new Scanner(System.in);
        String codes = sc.nextLine();
        String decodes = h.decodes(codes);
        System.out.println("对应的编码为：" + decodes);


    }
}
