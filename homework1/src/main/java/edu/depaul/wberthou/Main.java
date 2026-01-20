package edu.depaul.wberthou;

import edu.depaul.wberthou.graph.CampusBuilding;
import edu.depaul.wberthou.graph.Graph;
import edu.depaul.wberthou.graph.Node;
import edu.depaul.wberthou.search.AStar;
import edu.depaul.wberthou.search.IterativeDeepeningDFS;

import java.util.List;
import java.util.Optional;

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

        IterativeDeepeningDFS iddfs = new IterativeDeepeningDFS().setMaxSearchDepth(32);
        Optional<Node> start = graph.get(CampusBuilding.CLASSROOM_A.id());
        Optional<Node> target = graph.get(CampusBuilding.CONFERENCE_CENTER.id());

        if (start.isEmpty() || target.isEmpty()) {
            throw new RuntimeException("Cannot find start or end location. Graph may not be complete!");
        }

        System.out.println("IDDFS");
        iddfs.setTarget(target.get());
        List<Node> result = iddfs.iterativeDeepeningDepthFirstSearch(start.get());
        result.forEach(System.out::println);

        System.out.println("\n\nA*");
        AStar aStar = new AStar();
        List<Node> a = aStar.aStarSearch(graph, start.get(), target.get());
        a.forEach(System.out::println);

    }

}