package kruskal;

public class TripleComparator implements java.util.Comparator<Triple> {
    public int compare(Triple t1, Triple t2){
        return (int)(t1.value - t2.value);
    }
}
