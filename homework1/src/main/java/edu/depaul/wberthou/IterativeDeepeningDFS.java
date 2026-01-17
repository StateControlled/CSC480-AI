package edu.depaul.wberthou;

public class IterativeDeepeningDFS {
    private static final int DEPTH = 256;

    public static Node iterativeDeepeningDepthFirstSearch(Node root) {
        for (int i = 0; i < DEPTH; i++) {
            Solution solution = depthLimitedSearch(root, DEPTH);

            if (solution.found != null) {
                return solution.found;
            } else if (!solution.remaining) {
                return null;
            }
        }

        return null;
    }

    protected static Solution depthLimitedSearch(Node node, int depth) {
        if (depth == 0) {
            if (isGoal(node)) {
                return new Solution(node, true);
            } else {
                return new Solution(null, true);
            }
        } else {
            boolean anyRemaining = false;

            for (Node child : node.children) {
                Solution s = depthLimitedSearch(child, depth - 1);
                if (s.found != null) {
                    return new Solution(s.found, true);
                }
                if (s.remaining) {
                    anyRemaining = true;
                }
            }

            return new Solution(null, anyRemaining);
        }
    }

    private static boolean isGoal(Node node) {
        return false;
    }

    public record Solution(Node found, boolean remaining) {

    }

}
