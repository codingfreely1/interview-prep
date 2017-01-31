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
    public static <T extends Comparable<T>> void removeDuplicatesFromUnsortedList(Node<T> list) {
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
    public static <T extends Comparable<T>> void removeDuplicatesFromUnsortedListNoSpace(Node<T> list) {
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

    public static <T extends Comparable<T>> Node<T> reverseLinkedList(Node head){
        if(head == null){
            return head;
        }
        Node<T> prev = null;
        Node<T> cur = head;
        Node<T> next = cur.getNext();

        while(next != null){
            cur.setNext(prev);

            prev = cur;
            cur = next;
            next = next.getNext();
        }
        cur.setNext(prev);
        return cur;
    }

    public static <T extends Comparable<T>> boolean areListsEqual(Node<T> list1, Node<T> list2) {
        Node<T> cur1 = list1;
        Node<T> cur2 = list2;

        while(cur1 != null && cur2 != null ){
            if(!(cur1.getData().equals(cur2.getData()))){
                return false;
            }
            cur1 = cur1.getNext();
            cur2 = cur2.getNext();
        }
        return cur1 == cur2;
    }

    public static <T extends Comparable<T>> Node<T> mergeTwoLists(Node<T> list1, Node<T> list2){
            if(list1 == null) {
                return list2;
            } else if(list2 == null){
                return list1;
            }

            Node<T> a = list1;
            Node<T> b = list2;
            Node<T> newHead = null;
            Node<T> newTail = null;
            while(a != null && b!= null){
                if(a.getData().compareTo(b.getData()) < 0) {
                    if(newHead == null){
                        newHead = a;
                        newTail = a;
                    } else {
                        newTail.setNext(a);
                        newTail = newTail.getNext();
                    }
                    a = a.getNext();
                } else {
                    if(newHead == null){
                        newHead = b;
                        newTail = b;
                    } else {
                        newTail.setNext(b);
                        newTail = newTail.getNext();
                    }
                    b = b.getNext();
                }
            }

            if(a != null){
                newTail.setNext(a);
            }

            if(b != null) {
                newTail.setNext(b);
            }
            return newHead;
    }
}
