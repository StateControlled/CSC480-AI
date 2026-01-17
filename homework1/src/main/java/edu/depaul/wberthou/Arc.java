package edu.depaul.wberthou;

public class Arc {
    protected Node first;
    protected Node second;
    protected int distance;

    public Arc() {

    }

    public Arc(Node first, Node second, int distance) {
        this.first = first;
        this.second = second;
        this.distance = distance;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getSecond() {
        return second;
    }

    public void setSecond(Node second) {
        this.second = second;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}