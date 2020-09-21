package kruskal;

import java.util.Comparator;

public class MinSpanTree<T> {
    private Triple[] mst;

    private int cost = 0;
    /*public MinSpanTree(int n, Triple[] edges, Comparator<Triple> cmpr){
        mst = new Triple[n-1];
        Heap<Triple> minheap = new Heap<Triple>(true, edges, cmpr);
        UnionFindSet ufset = new UnionFindSet(n);
        System.out.println("并查集: " + ufset.toString() + ", 最小堆: " + minheap.toString());
        int i = 0;
        for (int j = 0; j < n; j++){
            Triple minedge = minheap.removeRoot();
            System.out.print("最小边" + minedge.toString() + ", ");
            if (ufset.union(minedge.row, minedge.column)){
                this.mst[i++] = minedge;
                this.cost += minedge.value;
                System.out.println("插入边" + minedge.toString() + ", " + "并查集" + ufset.toString());
            }
        }
    }*/



    private void sortEdges(Triple[] edges, int elen) {

        for (int i=0; i<elen; i++) {
            for (int j=i+1; j<elen; j++) {

                if (edges[i].value > edges[j].value) {
                    // 交换"边i"和"边j"
                    Triple tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }

    public MinSpanTree(MatrixGraph<T> graph){
        mst = new Triple[graph.vertexCount()];
        int n = graph.mEdgNum;
        Triple[] edges;
        edges = graph.getEdges();
        sortEdges(edges, n);
        UnionFindSet ufset = new UnionFindSet(n);
        int i = 0;
        for (int j = 0; j < n; j++){
            Triple minEdge = edges[j];
            if (ufset.union(minEdge.row, minEdge.column)){
                this.mst[i++] = minEdge;
                this.cost += minEdge.value;
                System.out.println(graph.mVexs[minEdge.row] + "---" + graph.mVexs[minEdge.column]);
            }
        }
        System.out.println("最小代价: " + cost);
    }



}
