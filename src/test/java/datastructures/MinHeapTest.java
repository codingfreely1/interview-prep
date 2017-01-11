package datastructures;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yael on 11/01/17.
 */
public class MinHeapTest {

    @Test
    public void testMinHeap(){
        MinHeap<Integer> minHeap = new MinHeap<>();

        minHeap.add(3);
        Assert.assertEquals(3,minHeap.peek().intValue());
        Assert.assertEquals(3,minHeap.removeMin().intValue());
        Assert.assertEquals(0,minHeap.size());

        minHeap.add(3);
        minHeap.add(5);
        Assert.assertEquals(3,minHeap.removeMin().intValue());
        Assert.assertEquals(5,minHeap.peek().intValue());

        minHeap.add(3);
        Assert.assertEquals(3,minHeap.peek().intValue());
        minHeap.add(2);
        Assert.assertEquals(2,minHeap.peek().intValue());
        minHeap.add(7);
        Assert.assertEquals(2,minHeap.peek().intValue());
        Assert.assertEquals(2,minHeap.removeMin().intValue());
        Assert.assertEquals(3,minHeap.peek().intValue());

    }
}
