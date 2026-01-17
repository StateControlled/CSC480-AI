package edu.depaul.wberthou.iterativeDeepeningDFS;

import edu.depaul.wberthou.goal.Goal;
import edu.depaul.wberthou.graph.Graph;
import edu.depaul.wberthou.graph.Node;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Iterative_deepening_depth-first_search">Wikipedia:Iterative Deepening Depth-First Search</a>
 */
public class IterativeDeepeningDFS<T> {
    private static final int DEPTH = 256;
    private final Graph graph;
    private Goal<T> goal;

    public IterativeDeepeningDFS(Graph graph) {
        this.graph = graph;
    }

    public void setGoal(Goal<T> goal) {
        this.goal = goal;
    }

    public Node iterativeDeepeningDepthFirstSearch(Node root) {
        for (int i = 0; i < DEPTH; i++) {
            InternalSolution solution = depthLimitedSearch(root, DEPTH);

            if (solution.found != null) {
                return solution.found;
            } else if (!solution.remaining) {
                return null;
            }
        }

        return null;
    }

    protected InternalSolution depthLimitedSearch(Node node, int depth) {
        if (depth == 0) {
            if (isGoal(node)) {
                return new InternalSolution(node, true);
            } else {
                return new InternalSolution(null, true);
            }
        } else {
            boolean anyRemaining = false;

            for (Node child : node.getChildren()) {
                InternalSolution s = depthLimitedSearch(child, depth - 1);
                if (s.found != null) {
                    return new InternalSolution(s.found, true);
                }
                if (s.remaining) {
                    anyRemaining = true;
                }
            }

            return new InternalSolution(null, anyRemaining);
        }
    }

    private boolean isGoal(Node node) {
        return false;
    }

    public record InternalSolution(Node found, boolean remaining) {

    }

}
