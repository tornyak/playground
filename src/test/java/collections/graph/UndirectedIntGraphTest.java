package collections.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class UndirectedIntGraphTest {

    @Test
    public void getNumberOfVertices() {
        IntGraph g = new UndirectedIntGraph(10);
        assertEquals(10, g.getNumberOfVertices());
    }

    @Test
    public void newGraphHasZeroEdges() {
        IntGraph g = new UndirectedIntGraph(10);
        assertEquals(0, g.getNumberOfEdges());
    }

    @Test
    public void connectedVerticesAreAdjacent() {
        IntGraph g = new UndirectedIntGraph(13);
        int[] edges = {0,1,0,2,0,5,0,6,3,4,3,5,7,8,9,10,9,11,9,12,11,12};
        for (int v = 1; v < edges.length; v++) {
            g.connect(edges[v-1], edges[v]);
        }

        for (int i = 1; i < edges.length; i++) {
            int v = edges[i-1];
            int w = edges[i];
            assertTrue("isAdjacent: " + v + "-" + w, g.isAdjacent(v, w));
        }
    }

    @Test
    public void getAdjacentVertices() {
    }
}