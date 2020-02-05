package collections.graph;

public interface IntGraph {
    int getNumberOfVertices();
    int getNumberOfEdges();
    IntGraph connect(int v, int w);
    boolean isAdjacent(int v, int w);
    Iterable<Integer> getAdjacentVertices(int v);

}
