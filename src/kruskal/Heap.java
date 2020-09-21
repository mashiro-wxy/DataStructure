/*
package kruskal;

import basic_class.SeqList;

import java.util.Comparator;
import java.*;

public class Heap<T> {
    private boolean minheap;
    private SeqList<T> heap;
    private Comparator<T> cmpr;

    public Heap(boolean minheap, Comparator<T> cmpr){
        this.minheap = minheap;
        this.heap = new SeqList<T>();
        this.cmpr = cmpr;
    }
    public Heap(boolean minheap){
        this(minheap,null);
    }
    public Heap(){
        this(true,null);
    }
    public Heap(boolean minheap, T[] values, Comparator<T> cmpr){
        this(minheap, cmpr);
        for (int i = 0; i < values.length; i++){
            this.insert(values[i]);
        }
    }
    public boolean isEmpty(){
        return this.heap.isEmpty();
    }
    public int size(){
        return this.heap.size();
    }
    public String toString(){
        return this.heap.toString();
    }
    public void insert(T x){
        this.heap.insert(x);
        for (int i = this.heap.size() / 2 - 1; i > 0; i = (i - 1) / 2)
            sift(i);
        sift(0);
    }
    public  void sift(int parent){
        int end = this.size() -1;
        int child = 2 * parent + 1;
        T value = this.heap.get(parent);
        while (child <= end){
            int comp = 0;
            if (child < end){
                T left = this.heap.get(child), right = this.heap.get(child +1);
                if (this.cmpr == null)
                    comp = ((Comparator<T>)left).compareTo(right);
                else comp = this.cmpr.compare(left, right);
                if (this.minheap ? comp > 0 : comp < 0){
                    child++;
                }
            }
            if (this.cmpr == null)
                comp = ((Comparator<T>)value).compareTo(this,heap.get(child));
            else comp = this.cmpr.compare(value, this,heap.get(child));
            if (this.minheap ? comp > 0 : comp < 0){
                this.heap.set(parent, this.heap.get(child));
                parent = child;
                child = 2 * parent + 1;
            }
            else break;
        }
        this.heap.set(parent, value);
    }
    public T removeRoot(){
        if (this.isEmpty())
            return null;
        T x = (T) this.heap.get(0);
        this.heap.set(0, this.heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);
        if (this.heap.size() > 1)
            sift(0);
        return x;
    }
}
*/
