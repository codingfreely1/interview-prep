package model;

import java.util.*;

/**
 * Created by yael on 04/01/17.
 */
public class ShortestPathNode<T> implements Comparable<ShortestPathNode<T>>{
    private int distance = Integer.MAX_VALUE;
    private T data;
    private ShortestPathNode<T> prev;
    private Map<ShortestPathNode<T>, Integer> neighbors;

    public ShortestPathNode(T data, Map<ShortestPathNode<T>, Integer> neighbors) {
        this.data = data;
        this.neighbors = neighbors;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ShortestPathNode<T> getPrev() {
        return prev;
    }

    public void setPrev(ShortestPathNode<T> prev) {
        this.prev = prev;
    }

    public Map<ShortestPathNode<T>, Integer> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Map<ShortestPathNode<T>, Integer> neighbors) {
        this.neighbors = neighbors;
    }

    public static <T> void printResults(ShortestPathNode<T> source){
        Set<ShortestPathNode<T>> visited = new HashSet<>();
        Queue<ShortestPathNode<T>> queue = new LinkedList<>();

        visited.add(source);
        queue.add(source);

        while (!queue.isEmpty()){
            ShortestPathNode<T> cur = queue.remove();
            cur.getNeighbors().keySet().forEach(n -> {if(!visited.contains(n)){
                visited.add(n);
                queue.add(n);
            }
            });
            System.out.println("data: " + cur.getData().toString() +
                                ", distance: " + cur.getDistance() +
                                ", prev: " + (cur.prev == null ? "null" : cur.prev.getData()));
        }
    }

    @Override
    public int compareTo(ShortestPathNode<T> tShortestPathNode) {
        return this.distance - tShortestPathNode.distance;
    }
}