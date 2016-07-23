package pl.misc.hackerank.graph;

/**
 * @author pallav
 * @version 1.0
 * @since 23/7/16
 */
public class Edge {

    public int start;
    public int end;
    public int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge otherEdge = (Edge) obj;
            return (start == otherEdge.start) && (end == otherEdge.end);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }
}