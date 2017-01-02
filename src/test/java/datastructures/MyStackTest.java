package datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by yael on 02/01/17.
 */
public class MyStackTest {

    @Test
    public void testMyStack(){
        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        Assert.assertEquals(stack.peek(), Integer.valueOf(1));
        Assert.assertEquals(stack.pop(), Integer.valueOf(1));

        IntStream.range(0,10).forEach(stack::push);
        IntStream.range(0,10).forEach(i -> Assert.assertEquals(stack.pop(), Integer.valueOf(9-i)));//FILO

        Assert.assertTrue(stack.empty());
    }
}