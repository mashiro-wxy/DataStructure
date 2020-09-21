package kruskal;

public class UnionFindSet {
    private int parent[];
    public UnionFindSet(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = -1;
        }
    }

    public int find(int i){
        while(parent[i] > 0){
            i = parent[i];
        }
        return i;
    }

    public boolean union(int i, int j){
        int rooti = collapsingFind(i);
        int rootj = collapsingFind(j);
        if (rooti != rootj){
            if (parent[rooti] <= parent[rootj]){
                parent[rooti] += parent[rootj];
                parent[rootj]=rooti;
            }
            else {
                parent[rootj] += parent[rooti];
                parent[rooti]=rootj;
            }
        }
        return rooti != rootj;
    }

    public int collapsingFind(int i){
        int root = i;
        while(parent[root] >= 0)
            root = parent[root];
        while (root != i && parent[i] != root){
            int j = parent[i];
            parent[i] = root;
            i = j;
        }
        return root;
    }
}
