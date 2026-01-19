package edu.depaul.wberthou.search;

import edu.depaul.wberthou.graph.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Iterative_deepening_depth-first_search">Wikipedia:Iterative Deepening Depth-First Search</a>
 * @see <a href="https://www.geeksforgeeks.org/dsa/iterative-deepening-searchids-iterative-deepening-depth-first-searchiddfs/">Geeks for Geeks:Iterative Deepening Depth-First Search</a>
 */
public class IterativeDeepeningDFS {
    private static final int DEPTH = 32;
    private Node target;

    public IterativeDeepeningDFS() {

    }

    public void setTarget(Node target) {
        this.target = target;
    }

    public Node iterativeDeepeningDepthFirstSearch(Node root) {
        List<Node> solutionPath = new ArrayList<>();

        for (int i = 0; i < DEPTH; i++) {
            InternalSolution solution = depthLimitedSearch(root, target, DEPTH);

            if (solution.foundTarget()) {
                return solution.found;
            } else if (!solution.hasRemaining()) {
                return null;
            }
            // else continue
        }

        return null;
    }

    protected InternalSolution depthLimitedSearch(Node node, Node target, int depth) {
        if (isGoal(node, target)) {
            return new InternalSolution(node, true);
        }

        if (depth <= 0) {
            return new InternalSolution(null, false);
        }

        boolean anyRemaining = false;

        for (Node child : node.getChildren()) {
            InternalSolution s = depthLimitedSearch(child, target, depth - 1);

            if (s.foundTarget()) {
                return new InternalSolution(s.found, true);
            }
            if (s.hasRemaining()) {
                anyRemaining = true;
            }
        }

        return new InternalSolution(null, anyRemaining);
    }

    private boolean isGoal(Node candidate, Node target) {
        return candidate.getName().equalsIgnoreCase(target.getName());
    }

    public record InternalSolution(Node found, boolean remaining) {
        public boolean foundTarget() {
            return found != null;
        }

        public boolean hasRemaining() {
            return remaining;
        }
    }

}
