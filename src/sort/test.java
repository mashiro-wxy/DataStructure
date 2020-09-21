package sort;

import java.util.Scanner;

public class test {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入人数: ");
        int num = sc.nextInt();

        System.out.println("\n希尔排序");
        int[] a = Array9.randomInt(num, 100);
        Array9.shellSort(a);
       for (int x : a){
           System.out.print(x +" ");
       }
       System.out.println("\n时间复杂度: n*(log2n)²");
       System.out.println("比较次数: " + Array9.k);

        System.out.println("\n快速排序");
        a = Array9.randomInt(num, 100);
        Array9.quickSort(a);
        for (int x : a){
            System.out.print(x +" ");
        }
        System.out.println("\n时间复杂度: n*(log2n)");
        System.out.println("比较次数: " + Array9.k);

        System.out.println("\n堆排序");
        a = Array9.randomInt(num, 100);
        Array9.heapSort(a, false);
        for (int x : a){
            System.out.print(x +" ");
        }
        System.out.println("\n时间复杂度: n*(log2n)");
        System.out.println("比较次数: " + Array9.k);

        System.out.println("\n归并排序");
        a = Array9.randomInt(num, 100);
        Array9.mergeSort(a);
        for (int x : a){
            System.out.print(x +" ");
        }
        System.out.println("\n时间复杂度: n*(log2n)");
        System.out.println("比较次数: " + Array9.k);
    }
}
