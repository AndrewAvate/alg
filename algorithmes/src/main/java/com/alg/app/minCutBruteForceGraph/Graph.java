package com.alg.app.minCutBruteForceGraph;

import java.util.*;

/**
 * Created by andrewavetisov on 26.11.16.
 */
public class Graph {

    private Set<String> vertices;
    private List<Edge> edges;

    public Graph() {
        vertices = new HashSet<String>();
        edges = new ArrayList<Edge>();
    }

    public Graph(Set<String> vertices, List<Edge> edges) {
        this.vertices = new HashSet<String>(vertices);
        this.edges = new ArrayList<Edge>(edges);
    }

    public Graph(Graph graph) {
        this.vertices = new HashSet<String>(graph.getVertices());
        this.edges = new ArrayList<Edge>(graph.getEdges());
    }

    public void addVertex(String vertex) {
        vertices.add(vertex);
    }

    public void addEdge(String firstVertex, String secondVertex) {
        if (vertices.contains(firstVertex) && vertices.contains(secondVertex)) {
            edges.add(new Edge(firstVertex, secondVertex));
        }
    }

    public Set<String> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Edge edge : edges) {
            result.append(edge.getFirstVertex())
                    .append(" -> ")
                    .append(edge.getSecondVertex())
                    .append("\n");
        }
        return result.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        List<Edge> clonedEdges = new ArrayList<Edge>();

        for (Edge edge : edges) {
            clonedEdges.add(new Edge(edge.getFirstVertex(), edge.getSecondVertex()));
        }

        return new Graph(new HashSet<String>(vertices), clonedEdges);
    }
}
