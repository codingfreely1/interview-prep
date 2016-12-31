package model;

import java.util.List;

/**
 * Created by yael on 30/12/16.
 */
public class Node<T> {
    private T data;
    private List<Node<T>> neighbors;

    public Node(T data, List<Node<T>> neighbors) {
        this.data = data;
        this.neighbors = neighbors;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Node<T>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node<T>> neighbors) {
        this.neighbors = neighbors;
    }
}
