package edu.depaul.wberthou;

import edu.depaul.wberthou.graph.Graph;
import edu.depaul.wberthou.iterativeDeepeningDFS.IterativeDeepeningDFS;

/**
 * Assignment 1
 * 2. 20 Points: Iterative Deepening Depth First Search
 * Consider just the connectivity of the locations in the graph above. Write an iterative
 * deepening depth first search program to find the best path from Class Room Building
 * A to the Conference Center.
 */
public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph("campus.json");
        graph.print();

        IterativeDeepeningDFS iddfs = new IterativeDeepeningDFS(graph);
    }

}