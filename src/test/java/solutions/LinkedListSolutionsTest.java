package solutions;

import model.linkedList.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    private <T> void printList(Node<T> node) {
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    private <T> Node<T> getTestList(List<T> collection) {
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
}
