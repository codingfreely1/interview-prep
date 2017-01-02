package datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by yael on 02/01/17.
 */
public class MyQueueTest {

    @Test
    public void testMyStack(){
        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(1);
        Assert.assertEquals(queue.poll(), Integer.valueOf(1));
        Assert.assertEquals(queue.remove(), Integer.valueOf(1));

        IntStream.range(0,10).forEach(queue::add);
        IntStream.range(0,10).forEach(i -> Assert.assertEquals(queue.remove(), Integer.valueOf(i)));//FIFO

        Assert.assertTrue(queue.poll() == null);
    }
}
