package sort;

import java.util.Random;

public class Array9 {

    public static int k = 0;

    //创建数组
    public static int[] randomInt(int n, int size){
        k = 0;
        Random ran = new Random();
        int num[] = new int[n];
        for (int i = 0; i < n; i++){
            num[i] = ran.nextInt(size);
        }
        return num;
    }

    //直接插入排序
    public static void insertSort(int[] keys){
        for (int i = 1; i < keys.length; i++){
            int temp = keys[i];
            int j;
            for (j = i - 1; j >= 0 && temp < keys[j]; j--) {
                keys[j + 1] = keys[j];
                k++;
            }
            keys[j+1] = temp;
        }
    }

    //希尔排序
    public static void shellSort(int[] keys){
        for (int delta = keys.length / 2; delta > 0; delta /= 2){
            for (int i = delta; i < keys.length; i++){
                int temp = keys[i];
                int j;
                for (j = i - delta; j >= 0 && temp < keys[j]; j -= delta) {
                    keys[j + delta] = keys[j];
                    k++;
                }
                keys[j + delta] = temp;
            }
        }
    }

    //交换
    private static void swap(int[] keys, int i, int j){
        int temp = keys[j];
        keys[j] = keys[i];
        keys[i] = temp;
    }

    //冒泡排序
    public static void bubbleSort(int[] keys, boolean asc){
        boolean exchange = true;
        for (int i = 1; i < keys.length && exchange; i++){
            exchange = false;
            for (int j = 0; j < keys.length - i; j++){
                k++;
                if (asc ? keys[j] > keys[j + 1] : keys[j] < keys[j + 1]){
                    swap(keys, j, j + 1);
                    exchange = true;
                }
            }
        }
    }
    public static void bubbleSort(int[] keys){
        bubbleSort(keys, true);
    }


    //快速排序
    /*public static void quickSort(int[] keys, int begin, int end){
        int i = begin;          //哨兵i
        int j = end;            //哨兵j
        int vot = keys[i];      //基准数
        while (i < j){
            //基准值在最左边.一定要哨兵j先移动
            while (i < j && keys[j] > vot){
                j--;
                k++;
            }
            //右移找到比基准数小的数
            while (i < j && keys[i] < vot){
                i++;
                k++;
            }
            if (keys[i] == keys[j] && i< j){
                i++;
            }
            else {
                int t = keys[i];
                keys[i] = keys[j];
                keys[j] = t;
            }
        }
        if (i-1 > begin) quickSort(keys, begin, i - 1);
        if (j+1 > end) quickSort(keys, j + 1, end);

    }*/
    public static void quickSort(int[] keys,int start,int end) {
        int pivot = keys[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(keys[j]>pivot)) {
                j--;
                k++;
            }
            while ((i<j)&&(keys[i]<pivot)) {
                i++;
                k++;
            }
            if ((keys[i]==keys[j])&&(i<j)) {
                i++;
            } else {
                int temp = keys[i];
                keys[i] = keys[j];
                keys[j] = temp;
            }
        }
        if (i-1>start) quickSort(keys,start,i-1);
        if (j+1<end) quickSort(keys,j+1,end);
    }
    public static void quickSort(int[] keys){
        quickSort(keys, 0, keys.length - 1);
    }

    //选择排序
    public static void selectSort(int[] keys){
        for (int i = 0; i < keys.length; i++){
            int min = i;
            for (int j = i + 1; j < keys.length; j++) {
                k++;
                if (keys[j] < keys[min])
                    min = j;
            }
            if (min != i)
                swap(keys, i, min);
        }
    }

    //筛选
    public static void sift(int[] keys, int parent, int end, boolean minheap){
        int child = 2 * parent + 1;
        int value = keys[parent];
        while (child <= end){
            k++;
            if (child < end && (minheap ? keys[child] > keys[child + 1] : keys[child] < keys[child + 1]))
                child++;
            if (minheap ? value > keys[child] : value < keys[child]){
                keys[parent] = keys[child];
                parent = child;
                child = 2 * parent + 1;
            }
            else break;;
        }
        keys[parent] = value;
    }

    //堆排序
    public static void heapSort(int[] keys, boolean minheap){
        for (int i = keys.length / 2 - 1; i >= 0; i--)
            sift(keys, i, keys.length - 1, minheap);
        for (int i = keys.length - 1; i > 0; i--){
            swap(keys, 0, i);
            sift(keys, 0, i - 1, minheap);
        }
    }
    public static void heapSort(int[] keys){
        heapSort(keys, true);
    }

    //一次归并
    /*private static void merge(int[] X, int[] Y, int begin1, int begin2, int n){
        int i = begin1, j = begin2, m = begin1;
        while (i < begin1 + n && j < begin2 + n && j < X.length) {
            while (i < begin1 + n && j < begin2 + n && j < X.length) {
                k++;
                if (X[i] < X[j])
                    Y[m++] = X[i++];
                else Y[m++] = X[j++];
            }
        }
        while (i < begin1 + n && i < X.length) {
            Y[m++] = X[i++];
            //k++;
        }
        while (j < begin2 + n && j < X.length) {
            Y[m++] = X[j++];
            //k++;
        }
    }*/
    /* L = 左边起始位置, R = 右边起始位置, RightEnd = 右边终点位置*/
    private static void merge( int A[], int TmpA[], int L, int R, int RightEnd )
    { /* 将有序的A[L]~A[R-1]和A[R]~A[RightEnd]归并成一个有序序列 */
        int LeftEnd, NumElements, Tmp;
        int i;
        LeftEnd = R - 1; /* 左边终点位置 */
        Tmp = L;         /* 有序序列的起始位置 */
        NumElements = RightEnd - L + 1;
        while( L <= LeftEnd && R <= RightEnd ) {
            k++;
            if ( A[L] <= A[R] )
                TmpA[Tmp++] = A[L++]; /* 将左边元素复制到TmpA */
            else
                TmpA[Tmp++] = A[R++]; /* 将右边元素复制到TmpA */
        }
        while( L <= LeftEnd )
            TmpA[Tmp++] = A[L++]; /* 直接复制左边剩下的 */
        while( R <= RightEnd )
            TmpA[Tmp++] = A[R++]; /* 直接复制右边剩下的 */
        for( i = 0; i < NumElements; i++, RightEnd -- )
            A[RightEnd] = TmpA[RightEnd]; /* 将有序的TmpA[]复制回A[] */
    }
    //一趟归并
    private static void mergePass(int[] X, int[] Y, int n){
        int i,j;
        for (i = 0; i <= X.length - 2 * n; i += 2 * n)
            merge(X, Y, i, i + n,  i + 2 * n - 1);
        if (i + n < X.length)
            merge(X, Y, i, i + n, X.length - 1);
        else
            for (j = i; j < X.length; j++) Y[j] = X[j];
    }
    //归并排序
    public static void mergeSort(int[] X){
        int[] Y = new int[X.length];
        int n = 1;
        while (n < X.length){
            mergePass(X, Y, n);
            n *= 2;
            if (n < X.length){
                mergePass(Y, X, n);
                n *= 2;
            }
        }
    }

}
