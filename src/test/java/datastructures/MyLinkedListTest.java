package datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by yael on 02/01/17.
 */
public class MyLinkedListTest {

    @Test
    public void testAddAndRemove(){
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        Assert.assertEquals(linkedList.size(), 1);
        Assert.assertTrue(linkedList.get(0) == 1);

        linkedList.remove(0);
        Assert.assertEquals(linkedList.size(), 0);

        linkedList.add(1);
        linkedList.add(2);
        linkedList.remove(0);
        Assert.assertEquals(linkedList.size(), 1);
        Assert.assertTrue(linkedList.get(0) == 2);


        linkedList.add(3);
        linkedList.add(4);
        linkedList.remove(1);
        Assert.assertEquals(linkedList.size(), 2);
        Assert.assertTrue(linkedList.get(0) == 2);
        Assert.assertTrue(linkedList.get(1) == 4);

        linkedList.remove(1);
        Assert.assertEquals(linkedList.size(), 1);
        Assert.assertTrue(linkedList.get(0) == 2);

        linkedList.remove(0);
        Assert.assertEquals(linkedList.size(), 0);
        Assert.assertTrue(linkedList.get(0) == null);
    }

    @Test
    public void testContains(){
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);

        Assert.assertTrue(linkedList.contains(1));
        Assert.assertFalse(linkedList.contains(9));
    }

    @Test
    public void testAddAllAndClear(){
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addAll(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        IntStream.range(0,10).forEach(i->Assert.assertTrue(linkedList.get(i) == i));
        linkedList.clear();
        Assert.assertEquals(linkedList.size(), 0);
    }
}
