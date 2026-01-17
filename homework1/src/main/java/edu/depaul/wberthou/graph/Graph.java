package edu.depaul.wberthou.graph;

import edu.depaul.wberthou.util.FileReader;

import java.io.IOException;
import java.util.List;

public class Graph {
    private final FileReader reader;
    private int vertices;
    private List<Node> nodes;
    /** Weighted edges **/
    private List<Arc> arcs;

    public Graph(String jsonFileName) {
        this.reader = new FileReader();
        init(jsonFileName);
    }

    protected void init(String filename) {
        FileReader.ResultPair<Node, Arc> result;
        try {
            result = reader.readFileToJavaObjects(filename);
            buildGraph(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void buildGraph(FileReader.ResultPair<Node, Arc> data) {
        this.nodes = data.result1();
        this.arcs = data.result2();

        this.vertices = nodes.size();

        connectNodes(arcs);
    }

    private void connectNodes(List<Arc> weightedEdges) {
        for (Arc arc : weightedEdges) {
            arc.first.addChild(arc.second);
        }
    }

    public void print() {
        nodes.forEach(System.out::println);
        System.out.println();
        arcs.forEach(System.out::println);
    }

    public List<Arc> getArcs() {
        return arcs;
    }

    public int size() {
        return vertices;
    }

}
