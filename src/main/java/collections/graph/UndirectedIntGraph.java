package collections.graph;

import java.util.Collection;
import java.util.HashSet;

public class UndirectedIntGraph implements IntGraph {
    private int numberOfVertices;
    private int numberOfEdges;
    private Collection<Integer>[] adjacencyLists;

    public UndirectedIntGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyLists = (Collection<Integer>[]) new HashSet[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyLists[i] = new HashSet<>();
        }
    }

    @Override
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    @Override
    public IntGraph connect(int v, int w) {
        adjacencyLists[v].add(w);
        adjacencyLists[w].add(v);
        numberOfEdges++;
        return this;
    }

    @Override
    public boolean isAdjacent(int v, int w) {
        return adjacencyLists[v].contains(w);
    }

    @Override
    public Iterable<Integer> getAdjacentVertices(int v) {
        return null;
    }

    @Override
    public String toString() {
        String result = numberOfVertices + " vertices, " +
                numberOfEdges + " edges\n";
        for (int v = 0; v < numberOfVertices; v++) {
            result += v + ": ";
            for (int w : adjacencyLists[v]) {
                result += w + " ";
            }
            result += "\n";
        }
        return result;
    }
}
