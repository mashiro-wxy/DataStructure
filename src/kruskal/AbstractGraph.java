package kruskal;

import basic_class.SeqList;

public abstract class AbstractGraph<T> {
    protected static final int MAX_WEIGHT = 0x0000ffff;
    protected SeqList<T> vertexlist;

    public AbstractGraph(int length){
        this.vertexlist = new SeqList<T>(length);
    }

    public AbstractGraph(){
        this(10);
    }

    public int vertexCount(){
        return this.vertexlist.size();
    }

    public String toString(){
        return "顶点集合: " + this.vertexlist.toString() + "\n";
    }

    public T getVertex(int i){
        return this.vertexlist.get(i);
    }

    public void setWertex(int i, T x){
        this.vertexlist.set(i, x);
    }

    public abstract int insertVertex(T x);
    //public abstract void insertEdge(int i,int j,int w);
    public abstract void removeVertex(int i);
    public abstract int weight(int i, int j);
    protected abstract int next(int i, int j);
}
