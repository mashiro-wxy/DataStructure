package kruskal;

public class test {
    public static void main(String args[]){
        String[] vertices = {"A","B","C","D","E","F"};
        Triple edges[] = {new Triple(0,1,26), new Triple(0,2,28), new Triple(0,3,15),
                new Triple(1,2,17), new Triple(1,4,13), new Triple(2,3,25),
                new Triple(2,4,21), new Triple(2,5,14), new Triple(3,5,18),
                new Triple(4,5,16)};
        MatrixGraph<String> matrixGraph = new MatrixGraph<>(vertices, edges);
        MinSpanTree mstree = new MinSpanTree(matrixGraph);
        //System.out.println("带权无向图G9");
    }
}
