package algorithms;

import algorithms.model.Position;
import org.junit.Assert;
import org.junit.Test;
import util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

import static algorithms.RecursionAndDynamicProgramming.*;

/**
 * Created by yael on 05/01/17.
 */
public class RecursionAndDynamicProgrammingTest {

    @Test
    public void testTowersOfHanoiMoveIfLegal(){

        Stack<Integer> source = new Stack<>();
        Stack<Integer> dest = new Stack<>();

        source.push(1);
        dest.push(2);
        moveIfLegal(source, dest);
        Assert.assertTrue(source.empty());
        moveIfLegal(dest, source);
        Assert.assertEquals(source.peek().intValue(), 1);
        moveIfLegal(dest, source);
        Assert.assertEquals(dest.peek().intValue(), 2);

        source.pop();
        moveIfLegal(dest, source);
        Assert.assertEquals(source.peek().intValue(), 2);
        moveIfLegal(source, dest);
        Assert.assertEquals(dest.peek().intValue(), 2);

        dest.pop();

    }

    @Test
    public void testTowersOfHanoi(){
        int n = 10;

        Stack<Integer> dest = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> source = new Stack<>();

        for (int i = 1; i <= n ; i++) {
            System.out.println("Iteration #" + i);
            initSourceStack(i, source);

            towersOfHanoi(source,middle,dest);

            Assert.assertTrue(source.empty());
            Assert.assertTrue(middle.empty());

            IntStream.rangeClosed(1,i).forEach(j -> {
                System.out.println(dest.peek());
                Assert.assertEquals(dest.pop().intValue(), j);
            });

           Assert.assertTrue(dest.empty());
        }
    }

    private void initSourceStack(int n, Stack<Integer> source){
        IntStream.range(0,n).forEach(j -> {
            source.push(n - j);
        });
    }

    @Test
    public void testFindPath(){
        List<Position.Direction> path = new ArrayList<>();
        findPath(path, new Position(0,0), new Position(2,2) , new Position(3,3));
        System.out.println(Utils.listWithCommaSeparator(path));
    }
}
