package algorithms;

import model.Node;
import model.ShortestPathNode;

import java.util.*;

/**
 * Created by yael on 30/12/16.
 */
public class GraphAlgorithms {

    public static <T> void traverseBFS(Node<T> node){
        Set<Node<T>> visited = new HashSet<>();
        Queue<Node<T>> queue = new LinkedList<>();

        visited.add(node);
        queue.add(node);

        while (!queue.isEmpty()){
            Node<T> cur = queue.remove();
            cur.getNeighbors().forEach(n -> {if(!visited.contains(n)){
                visited.add(n);
                queue.add(n);
            }
            });
            System.out.println("visited: " + cur.getData().toString());
        }
    }

    private static Set<Node> visitedDFS = new HashSet<>();

    public static <T> void traversDFS(Node<T> node){
        visitedDFS.add(node);
        System.out.println("visited: " + node.getData().toString());
        node.getNeighbors().forEach(n -> {
            if(!(visitedDFS.contains(n))) {
                traversDFS(n);
            }
        });
    }

    public static <T extends Comparable<T>> void dijkstra(ShortestPathNode<T> source){
        Queue<ShortestPathNode<T>> queue = new LinkedList<>();
        Set<ShortestPathNode<T>> visited = new HashSet<>();

        source.setDistance(0);
        queue.add(source);

        while (!queue.isEmpty()) {
            ShortestPathNode<T> cur = queue.remove();

            Map<ShortestPathNode<T>, Integer> edges = cur.getNeighbors();
            Set<ShortestPathNode<T>> s = cur.getNeighbors().keySet();
            ArrayList<ShortestPathNode<T>> sorted = new ArrayList<>(s);
            Collections.sort(sorted);

            sorted.forEach(n -> {
                if(!visited.contains(n)){
                    queue.add(n);
                    int newDistance = cur.getDistance() + edges.get(n);
                    if(newDistance < n.getDistance()){
                        n.setDistance(newDistance);
                        n.setPrev(cur);
                    }
                }
            });
            visited.add(cur);
        }
    }

}
