package edu.depaul.wberthou;

import edu.depaul.wberthou.graph.CampusBuilding;
import edu.depaul.wberthou.graph.Initializer;
import edu.depaul.wberthou.graph.Node;
import edu.depaul.wberthou.search.IterativeDeepeningDFS;

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
        Initializer initializer = new Initializer("campus.json");
//        graph.print();

        IterativeDeepeningDFS iddfs = new IterativeDeepeningDFS();
        Optional<Node> start = initializer.get(CampusBuilding.CLASSROOM_A.id());
        Optional<Node> target = initializer.get(CampusBuilding.CONFERENCE_CENTER.id());

        if (start.isEmpty() || target.isEmpty()) {
            throw new RuntimeException("Cannot find start or end location. Graph may not be complete!");
        }

        iddfs.setTarget(target.get());
        Node result = iddfs.iterativeDeepeningDepthFirstSearch(start.get());
        System.out.println(result);
    }

}