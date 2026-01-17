package edu.depaul.wberthou;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    protected String name;
    protected int x;
    protected int y;
    protected List<Node> children;

    public Node() {

    }

    public Node(String name, int x, int y, List<Node> children) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.children = Objects.requireNonNullElseGet(children, ArrayList::new);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public int numberOfChildren() {
        return children.size();
    }

    public List<Node> getChildren() {
        return children;
    }
}

