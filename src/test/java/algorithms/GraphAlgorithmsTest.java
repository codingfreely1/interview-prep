package algorithms;

import algorithms.GraphAlgorithms;
import model.Node;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by yael on 30/12/16.
 */
public class GraphAlgorithmsTest {

    @Test
    public void testBFS(){
        System.out.println("testBFS");
        Node<Integer> n1 = getTestGraph();

        GraphAlgorithms.traverseBFS(n1);
    }

    @Test
    public void testDFS(){
        System.out.println("testDFS");
        Node<Integer> n1 = getTestGraph();
        GraphAlgorithms.traversDFS(n1);
    }

    private Node<Integer> getTestGraph() {
        Node<Integer> n1 = new Node<>(1, new ArrayList<>());
        Node<Integer> n2 = new Node<>(2, new ArrayList<>());
        Node<Integer> n3 = new Node<>(3, new ArrayList<>());
        Node<Integer> n4 = new Node<>(4, new ArrayList<>());
        Node<Integer> n5 = new Node<>(5, new ArrayList<>());

        n1.getNeighbors().add(n2);
        n1.getNeighbors().add(n2);

        n2.getNeighbors().add(n3);
        n2.getNeighbors().add(n4);
        n2.getNeighbors().add(n5);

        n5.getNeighbors().add(n2);
        return n1; //note that dfs/bfs will traverse over the connected components. If returning n2 then n1 will not be reached.
    }

    @Test
    public void testBFS1(){
        System.out.println("testBFS1");
        Node<Integer> n1 = getTestGraph2();
        GraphAlgorithms.traverseBFS(n1);
    }

    @Test
    public void testDFS1(){
        System.out.println("testDFS");
        Node<Integer> n1 = getTestGraph2();
        GraphAlgorithms.traversDFS(n1);
    }
    private Node<Integer> getTestGraph2() {
        Node<Integer> n0 = new Node<>(0, new ArrayList<>());
        Node<Integer> n1 = new Node<>(1, new ArrayList<>());
        Node<Integer> n2 = new Node<>(2, new ArrayList<>());
        Node<Integer> n3 = new Node<>(3, new ArrayList<>());
        Node<Integer> n4 = new Node<>(4, new ArrayList<>());
        Node<Integer> n5 = new Node<>(5, new ArrayList<>());

        n0.getNeighbors().add(n1);
        n0.getNeighbors().add(n4);
        n0.getNeighbors().add(n5);

        n1.getNeighbors().add(n3);
        n1.getNeighbors().add(n4);

        n2.getNeighbors().add(n1);

        n3.getNeighbors().add(n2);
        n3.getNeighbors().add(n4);

        return n0;
    }
}
