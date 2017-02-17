package solutions;

import model.DoubleLinkedNode;
import model.linkedList.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by yael on 03/01/17.
 */
public class LinkedListSolutionsTest {

    @Test
    public void testRemoveDuplicates(){
        List<Integer> linkedList = new LinkedList<>();

        linkedList.addAll(Arrays.asList(1,4,66,4,1));
        LinkedListSolutions.removeDuplicatesFromUnsortedList(linkedList);

        Assert.assertEquals(3, linkedList.size());
        linkedList.forEach(System.out::println);
    }

    @Test
    public void testRemoveDuplicates2(){
        Node<Integer> linkedList = getTestList(Arrays.asList(1,4,66,4,1));
        LinkedListSolutions.removeDuplicatesFromUnsortedList(linkedList);
        printList(linkedList);
    }

    @Test
    public void testRemoveDuplicatesNoSpace(){
        Node<Integer> linkedList = getTestList(Arrays.asList(1,4,66,4,1));
        LinkedListSolutions.removeDuplicatesFromUnsortedListNoSpace(linkedList);
        printList(linkedList);
    }

    @Test
    public void testRemoveDuplicatesNoSpace2(){
        Node<Integer> linkedList = getTestList(Arrays.asList(1,1,1,3));
        LinkedListSolutions.removeDuplicatesFromUnsortedListNoSpace(linkedList);
        printList(linkedList);
    }

    private <T extends Comparable<T>> void printList(Node<T> node) {
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    private <T extends Comparable<T>> Node<T> getTestList(List<T> collection) {
        Node<T> next  = null;

        for (int i = collection.size() -1; i >= 0 ; i--) {
            next = new Node<>(collection.get(i), next) ;
        }
        return next;
    }

    @Test
    public void testReverseList(){
        Node<Integer> linkedList = getTestList(Arrays.asList(1,1,1,3));
        Node<Integer> reverseLinkedList = LinkedListSolutions.reverseLinkedList(linkedList);
        Node<Integer> backToOrig = LinkedListSolutions.reverseLinkedList(reverseLinkedList);

        Assert.assertTrue(LinkedListSolutions.areListsEqual(linkedList, backToOrig));
    }

    @Test
    public void testMergeTwoLists(){
        Node<Integer> list1 = getTestList(Arrays.asList(1,5,5,7));
        Node<Integer> list2 = getTestList(Arrays.asList(3,5,6,8));

        Node<Integer> merged = LinkedListSolutions.mergeTwoLists(list1, list2);
        Node<Integer> expected = getTestList(Arrays.asList(1,3,5,5,5,6,7,8));

        Assert.assertTrue(LinkedListSolutions.areListsEqual(merged, expected));
    }

    @Test
    public void testCountComponents() {
        DoubleLinkedNode<Character> a = new DoubleLinkedNode<>('a', null, null);
        DoubleLinkedNode<Character> b = new DoubleLinkedNode<>('b', a, null);
        a.right = b;
        DoubleLinkedNode<Character> c = new DoubleLinkedNode<>('c', b, null);
        b.right = c;
        DoubleLinkedNode<Character> d = new DoubleLinkedNode<>('d', c, null);
        c.right = d;
        DoubleLinkedNode<Character> e = new DoubleLinkedNode<>('e', d, null);
        d.right = e;
        DoubleLinkedNode<Character> f = new DoubleLinkedNode<>('f', e, null);
        e.right = f;

        Set<DoubleLinkedNode> nodes = new HashSet<>();
        nodes.add(a);
        nodes.add(d);
        nodes.add(e);
        nodes.add(f);

        Assert.assertEquals( 2, LinkedListSolutions.countConnectedComponents(nodes));
    }
}
