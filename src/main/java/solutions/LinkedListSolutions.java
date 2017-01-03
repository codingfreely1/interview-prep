package solutions;


import model.linkedList.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yael on 03/01/17.
 */
public class LinkedListSolutions {

    // question 2.1 page 94
    public static <T> void removeDuplicatesFromUnsortedList(List<T> list) {
        Set<T> map = new HashSet<>();
        for (T element: list) {
            map.add(element);
        }
        list.clear();
        list.addAll(map);
    }

    /**
     * O(N) running time. O(N) space
     * @param list
     * @param <T>
     */
    public static <T> void removeDuplicatesFromUnsortedList(Node<T> list) {
        Set<T> set = new HashSet<>();

        Node<T> curNode = list;
        Node<T> previous = null;

        while(curNode != null) {
            if(set.contains(curNode.getData())) {
                assert previous != null;
                previous.setNext(curNode.getNext()); // removing curNode.
            } else {
                set.add(curNode.getData());
                previous = curNode;
            }
            curNode = curNode.getNext();
        }
    }

    /**
     * O(N^2) running time. O(1) space.
     * @param list
     * @param <T>
     */
    public static <T> void removeDuplicatesFromUnsortedListNoSpace(Node<T> list) {
        Node<T> cur = list;
        Node<T> runner;

        while(cur != null) {
            T val = cur.getData();
            runner = cur;
            while(runner.getNext() != null){
                if(runner.getNext().getData().equals(val)) {
                    //removing
                    runner.setNext(runner.getNext().getNext());
                } else{
                    runner = runner.getNext();
                }
            }
            cur = cur.getNext();
        }

    }
    // question 2.1 page 94 - end
}
