package kruskal;

import sparse_matrix.Matrix;

public class MatrixGraph<T> extends AbstractGraph<T> {
    protected Matrix matrix;
    public int mEdgNum;
    public T[] mVexs;       // 顶点集合

    public MatrixGraph(int length){
        super(length);
        matrix = new Matrix(length);
    }

    public MatrixGraph(){
        this(10);
    }

    public MatrixGraph(T[] vertices){
        this(vertices.length);
        for (int i = 0; i < vertices.length; i++)
            this.insertVertex(vertices[i]);
        mVexs = vertices;
    }

    public MatrixGraph(T[] vertices, Triple[] edges){
        this(vertices);
        for (int j = 0; j < edges.length; j++)
            this.insertEdge(edges[j]);
        mEdgNum = edges.length;
    }

    public String toString(){
        String str = super.toString() + "邻接矩阵: \n";
        int n = this.vertexCount();
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix.get(i,j) == MAX_WEIGHT){
                    str += "    ∞";
                }else str += String.format("%6d",matrix.get(i,j));
            }
            str += "\n";
        }
        return str;
    }

    @Override
    public int insertVertex(T x) {
        int i = this.vertexlist.insert(x);
        if(i >= matrix.getRows()){
            matrix.setRowsColumns(i+1, i+1);
        }
        for(int j = 0; j < i; j++){
            matrix.set(i,j,MAX_WEIGHT);
            matrix.set(j,i,MAX_WEIGHT);
        }
        return i;
    }

    public void insertEdge(int i,int j,int w) {
        if (i != j){
            if (w <= 0 || w > MAX_WEIGHT){
                w = MAX_WEIGHT;
            }
            matrix.set(i,j,w);
        }
        else throw new IllegalArgumentException("不能插入自身环, i=" + i + ", j=" + j);
    }

    public void insertEdge(Triple edge){
        this.insertEdge(edge.row, edge.column, edge.value);
    }

    public void removeEdge(int i, int j) {
        if (i != j)
            matrix.set(i,j,MAX_WEIGHT);
    }

    public void removeEdge(Triple edge) {
       this.removeEdge(edge.row, edge.column);
    }

    public Triple[] getEdges() {
        int index=0;
        Triple[] edges;

        edges = new Triple[mEdgNum];
        for (int i=0; i < mVexs.length; i++) {
            for (int j=i+1; j < mVexs.length; j++) {
                if (matrix.element[i][j]!=MAX_WEIGHT) {
                    edges[index++] = new Triple(i, j, matrix.element[i][j]);
                }
            }
        }

        return edges;
    }


    @Override
    public void removeVertex(int i) {
        int n = this.vertexCount();
        if(i >= 0 && i < n){
            this.vertexlist.remove(i);
            for (int j = i + 1; j < n; j++){
                for (int k = 0; k < n; k++){
                    matrix.set(j-1,k,matrix.get(j,k));
                }
            }
            for (int j = 0; j < n; j++){
                for (int k = i + 1; k < n; k++){
                    matrix.set(j,k-1,matrix.get(j,k));
                }
            }
            matrix.setRowsColumns(n-1,n-1);
        }
        else throw new IndexOutOfBoundsException("i=" + i);
    }

    @Override
    public int weight(int i, int j) {
        return matrix.get(i,j);
    }

    @Override
    protected int next(int i, int j) {
        int n = this.vertexCount();
        if (i >= 0 && i < n && j >= -1 && j < n && i != j){
            for (int k = j + 1; k < n; k++){
                if(matrix.get(i,k) > 0 && matrix.get(i,k) < MAX_WEIGHT){
                    return k;
                }
            }
        }
        return -1;
    }

}
