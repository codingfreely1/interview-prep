package datastructures;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yael on 03/01/17.
 */
public class QueueUsingTwoStacksTest {

    @Test
    public void testQueue(){
        QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();

        queue.add(1);
        Assert.assertEquals(queue.poll().intValue(), 1);
        Assert.assertEquals(queue.remove().intValue(), 1);

        queue.add(2);
        queue.add(3);
        queue.add(4);

        Assert.assertEquals(queue.size(), 3);
        Assert.assertEquals(queue.remove().intValue(), 2);
        Assert.assertEquals(queue.remove().intValue(), 3);
        Assert.assertEquals(queue.size(), 1);
        Assert.assertEquals(queue.remove().intValue(), 4);

    }
}