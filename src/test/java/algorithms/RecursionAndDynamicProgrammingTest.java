package algorithms;

import algorithms.model.Position;
import org.junit.Assert;
import org.junit.Test;
import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    public void testMagicIndex(){
        int[] arr = {-2,-3, 2, 4,5} ;
        int magicIndex = searchMagicIndex(arr, 0, arr.length-1);
        Assert.assertEquals(2, magicIndex);

        int[] arr2 = {0,2, 3, 4,5} ;
        magicIndex = searchMagicIndex(arr2, 0, arr.length-1);
        Assert.assertEquals(0, magicIndex);

        int[] arr3 = {-1,2,1,3,5,6} ;
        magicIndex = searchMagicIndex(arr3, 0, arr.length-1);
        Assert.assertEquals(3, magicIndex);
    }

    @Test
    public void testPrintParens() {
        for (int i = 0; i < 4; i++) {
            System.out.println("i = " + i);
            printLegalParens(new ArrayList<>(), i, 0, 0);
        }
    }

    @Test
    public void testQueensPlacementsOnBoard(){
        List<Integer[]> possiblePlacements = RecursionAndDynamicProgramming.placeQueens(8);
        StringBuilder sb = new StringBuilder();
        possiblePlacements.forEach(arr -> {
            for (int j = 0; j < arr.length; j++) {
                sb.append("(").append(j).append(",").append(arr[j]).append(')');
            }
            System.out.println(sb.toString());
            sb.setLength(0);
        });

    }

}
