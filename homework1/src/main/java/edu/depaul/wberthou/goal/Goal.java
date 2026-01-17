package edu.depaul.wberthou.goal;

@FunctionalInterface
public interface Goal<T> {
    /**
     * @param candidate an object to be tested against the goal
     *
     * @return  <code>true</code> if the candidate matches the goal
     */
    boolean isGoal(T candidate);
}
