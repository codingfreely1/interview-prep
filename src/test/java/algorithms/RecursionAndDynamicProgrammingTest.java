package algorithms;

import algorithms.model.Position;
import org.junit.Assert;
import org.junit.Test;
import util.Utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

import static algorithms.RecursionAndDynamicProgramming.*;

/**
 * Created by yael on 05/01/17.
 */
public class RecursionAndDynamicProgrammingTest {

    @Test
    public void testFibonacci(){
        testFibonacci(RecursionAndDynamicProgramming::fibonacci);
    }

    @Test
    public void testFibonacciDynamic(){
        testFibonacci(RecursionAndDynamicProgramming::fibonacciDynamic);
    }

    @Test
    public void testFibonacciIterative(){
        testFibonacci(RecursionAndDynamicProgramming::fibonacciIterative);
    }

    private void testFibonacci(Function<Integer, Integer> function){
        Assert.assertEquals(0,function.apply(0).intValue());
        Assert.assertEquals(1,function.apply(1).intValue());
        Assert.assertEquals(1,function.apply(2).intValue());
        Assert.assertEquals(2,function.apply(3).intValue());
        Assert.assertEquals(3,function.apply(4).intValue());
        Assert.assertEquals(5,function.apply(5).intValue());
        Assert.assertEquals(8,function.apply(6).intValue());
        Assert.assertEquals(13,function.apply(7).intValue());
        Assert.assertEquals(21,function.apply(8).intValue());
    }

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

    @Test
    public void testBooleanEvaluation(){
        Assert.assertEquals(RecursionAndDynamicProgramming.evaluate("0&1", false), 1);
        Assert.assertEquals(RecursionAndDynamicProgramming.evaluate("0&1", true), 0);
        Assert.assertEquals(RecursionAndDynamicProgramming.evaluate("0&1|0", false), 2);
        Assert.assertEquals(RecursionAndDynamicProgramming.evaluate("1^0|0|1", false), 2);

        useOptimization = false;
        Assert.assertEquals(RecursionAndDynamicProgramming.evaluate("0&0&0&1^1|0", true), 10);
        System.out.println("recursionLevel: " + recursionLevel);
        recursionLevel = 0;
        useOptimization = true;
        Assert.assertEquals(RecursionAndDynamicProgramming.evaluate("0&0&0&1^1|0", true), 10);
        System.out.println("recursionLevel: " + recursionLevel);
    }

    @Test
    public void testFindAllSubset(){
        testFindAllSubsetFunction(RecursionAndDynamicProgramming::findAllSubset);
    }

    @Test
    public void testIsBitSetInIndex(){
        Assert.assertTrue(RecursionAndDynamicProgramming.isBitSetInIndex(0, 1));
        Assert.assertFalse(RecursionAndDynamicProgramming.isBitSetInIndex(0, 0));

        Assert.assertTrue(RecursionAndDynamicProgramming.isBitSetInIndex(0, 3));
        Assert.assertTrue(RecursionAndDynamicProgramming.isBitSetInIndex(1, 3));
        Assert.assertFalse(RecursionAndDynamicProgramming.isBitSetInIndex(2, 3));

        Assert.assertFalse(RecursionAndDynamicProgramming.isBitSetInIndex(1, 8));
        Assert.assertFalse(RecursionAndDynamicProgramming.isBitSetInIndex(2, 8));
        Assert.assertTrue(RecursionAndDynamicProgramming.isBitSetInIndex(3, 8));

        Assert.assertTrue(RecursionAndDynamicProgramming.isBitSetInIndex(8, 256));
    }

    @Test
    public void testFindAllSubsetIteratively(){
        testFindAllSubsetFunction(RecursionAndDynamicProgramming::findAllSubsetIteratively);

    }

    @Test
    public void testFindAllSubsetIteratively2(){
        testFindAllSubsetFunction(RecursionAndDynamicProgramming::findAllSubsetIteratively2);
    }

    @Test
    public void testFindAllSubsetSolution3(){
        testFindAllSubsetFunction(RecursionAndDynamicProgramming::findAllSubsetSolution3);
    }

    private void testFindAllSubsetFunction(Function<Integer[], List<List<Integer>>> function){
        Integer[] set1 = {0, 1};
        List<List<Integer>> list =  function.apply(set1);
        Assert.assertEquals(4, list.size());
        list.forEach(i-> System.out.println(Utils.listWithCommaSeparator(i)));

        Integer[] set2 = {0, 1, 2};
        List<List<Integer>> list2 = function.apply(set2);
        Assert.assertEquals(8, list2.size());
        list2.forEach(i-> System.out.println(Utils.listWithCommaSeparator(i)));
    }

    @Test
    public void testComputePermutationsWithoutDupsIteratively(){
        testComputePermutationsWithoutDups(RecursionAndDynamicProgramming::computeAllPermutationsIteratively);
    }

    @Test
    public void testComputePermutationsWithoutDupsRecursively(){
        testComputePermutationsWithoutDups(RecursionAndDynamicProgramming::computeAllPermutationsRecursively);
    }

    private void testComputePermutationsWithoutDups(Function<String, List<String>> func){
        List<String> list = func.apply("ab");
        System.out.println(Utils.listWithCommaSeparator(list));
        list = func.apply("abc");
        System.out.println(Utils.listWithCommaSeparator(list));
        list = func.apply("abcdef");
        Assert.assertEquals(6*5*4*3*2, list.size());
        System.out.println(Utils.listWithCommaSeparator(list));
    }

    @Test
    public void testComputePermutationsWithDups(){
        List<String> list = RecursionAndDynamicProgramming.getPermsWithDups("ab");
        System.out.println(Utils.listWithCommaSeparator(list));
        list = RecursionAndDynamicProgramming.getPermsWithDups("aa");
        System.out.println(Utils.listWithCommaSeparator(list));
        list = RecursionAndDynamicProgramming.getPermsWithDups("aabb");
        System.out.println(Utils.listWithCommaSeparator(list));

        list = RecursionAndDynamicProgramming.getPermsWithDups("abc");
        System.out.println(Utils.listWithCommaSeparator(list));
        list = RecursionAndDynamicProgramming.getPermsWithDups("aabbbcccc");
        Assert.assertEquals(MathAlgorithms.calcNchooseK(9,2) * MathAlgorithms.calcNchooseK(9-2,3), list.size());
        System.out.println(list.size());
        System.out.println(Utils.listWithCommaSeparator(list));
    }

    @Test
    public void testCalcLengthRecursive(){
        testCalcLength(RecursionAndDynamicProgramming::calcBoardLengthsRecursive);
    }

    @Test
    public void testCalcLengthSimple(){
        testCalcLength(RecursionAndDynamicProgramming::calcBoardLengthsSimple);
    }

    private void testCalcLength(Function<Integer, Set<Integer>> function){
        Set<Integer> expected = new HashSet<>();
        expected.add(shortLen);
        expected.add(longLen);
        Assert.assertEquals(expected, function.apply(1));

        expected = new HashSet<>();
        expected.add(shortLen + shortLen);
        expected.add(shortLen + longLen);
        expected.add(longLen + longLen);
        Assert.assertEquals(expected, function.apply(2));
    }
}
