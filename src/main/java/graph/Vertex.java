package graph;

import java.util.List;

/**
 * Created by david on 3/8/17.
 */
public class Vertex {
    private String name;
    private List<Edge> connections;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getConnections() {
        return connections;
    }

    public void setConnections(List<Edge> connections) {
        this.connections = connections;
    }
}
