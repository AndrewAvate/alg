package com.alg.app.minCutBruteForceGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by andrewavetisov on 26.11.16.
 */
public class MinimumCutBruteForceAlg {

    public Graph findMinimumCutAlg(Graph graph) throws CloneNotSupportedException {
        double count = Math.pow(graph.getVertices().size(), 2) * Math.log(graph.getVertices().size());


        Graph minGraph = graph;

        for (int i=0; i < count; i++) {

            Graph currentGraph = findCutAlg(graph);
            if (currentGraph.getEdges().size() < minGraph.getEdges().size()) {
                minGraph = currentGraph;
            }
        }
        return minGraph;
    }

    private Graph findCutAlg(Graph graph) throws CloneNotSupportedException {
        Graph currentGraph = (Graph) graph.clone();

        while (currentGraph.getVertices().size() > 2) {
            int randomEdgeIdx = new Random().nextInt(currentGraph.getEdges().size());
            mergeVertices(randomEdgeIdx, currentGraph);
            removeSefLoop(currentGraph);
            findCutAlg(currentGraph);
        }
        return currentGraph;
    }


    private void mergeVertices(int edgeIdx, Graph graph) {
        List<Edge> edgeList = graph.getEdges();
        String firstVertex = edgeList.get(edgeIdx).getFirstVertex();
        String secondVertex = edgeList.get(edgeIdx).getSecondVertex();

        String mergedVertex = firstVertex + ";" + secondVertex;

        //direct edges to th first vertex
        for (Edge edge : graph.getEdges()) {
            if (edge.getFirstVertex().equals(secondVertex) || edge.getFirstVertex().equals(firstVertex)) {
                edge.setFirstVertex(mergedVertex);
            }
            if (edge.getSecondVertex().equals(secondVertex) || edge.getSecondVertex().equals(firstVertex)) {
                edge.setSecondVertex(mergedVertex);
            }
        }

        //remove second vertex
        graph.getVertices().remove(secondVertex);
        graph.getVertices().remove(firstVertex);
        graph.getVertices().add(mergedVertex);

    }

    private void removeSefLoop(Graph graph) {
        List<Edge> edgeList = graph.getEdges();
        List<Edge> selfLoopEdgeList = new ArrayList<Edge>();
        for (Edge edge : edgeList) {
            if (edge.getFirstVertex().equals(edge.getSecondVertex())) {
                selfLoopEdgeList.add(edge);
            }
        }
        for (Edge edge : selfLoopEdgeList) {
            edgeList.remove(edge);
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Graph graph = new Graph();

/*
        graph.getVertices().add("A");
        graph.getVertices().add("B");
        graph.getVertices().add("C");
        graph.getVertices().add("D");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "A");
        graph.addEdge("B", "D");
*/

        graph.getVertices().add("A");
        graph.getVertices().add("B");
        graph.getVertices().add("E");
        graph.getVertices().add("F");

        graph.getVertices().add("C");
        graph.getVertices().add("D");
        graph.getVertices().add("G");
        graph.getVertices().add("H");

        graph.addEdge("A", "B");
        graph.addEdge("B", "F");
        graph.addEdge("F", "E");
        graph.addEdge("E", "A");
        graph.addEdge("A", "F");
        graph.addEdge("B", "E");

        graph.addEdge("B", "C");
        graph.addEdge("F", "G");

        graph.addEdge("C", "D");
        graph.addEdge("D", "H");
        graph.addEdge("H", "G");
        graph.addEdge("G", "C");
        graph.addEdge("C", "H");
        graph.addEdge("G", "D");


        MinimumCutBruteForceAlg cutAlg = new MinimumCutBruteForceAlg();
        Graph cutedGraph = cutAlg.findMinimumCutAlg(graph);


        System.out.println(cutedGraph);
    }

}
