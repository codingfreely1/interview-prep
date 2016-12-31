import model.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

}
