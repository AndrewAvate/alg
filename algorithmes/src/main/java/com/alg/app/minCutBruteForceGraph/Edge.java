package com.alg.app.minCutBruteForceGraph;

/**
 * Created by andrewavetisov on 26.11.16.
 */
public class Edge {

    private String firstVertex;
    private String secondVertex;

    public Edge(String firstVertex, String secondVertex) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
    }

    public String getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(String firstVertex) {
        this.firstVertex = firstVertex;
    }

    public String getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(String secondVertex) {
        this.secondVertex = secondVertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (firstVertex != null ? !firstVertex.equals(edge.firstVertex) : edge.firstVertex != null) return false;
        return secondVertex != null ? secondVertex.equals(edge.secondVertex) : edge.secondVertex == null;
    }

    @Override
    public int hashCode() {
        int result = firstVertex != null ? firstVertex.hashCode() : 0;
        result = 31 * result + (secondVertex != null ? secondVertex.hashCode() : 0);
        return result;
    }

}
