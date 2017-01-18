package algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by yael on 31/12/16.
 */
public class SortingAlgorithmsTest {

    @Test
    public void testBubbleSort(){
        List<Integer> list = Arrays.asList(10,9,1,8,0);
        List<Integer> expected = Arrays.asList(0,1,8,9,10);

        SortingAlgorithms.bubbleSort(list);
        Assert.assertEquals(expected, list);
    }

    @Test
    public void testBubbleSort2(){
        List<Integer> list = Arrays.asList(10,9,8,7,6,5,4,3,2,1,0);
        List<Integer> expected = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);

        SortingAlgorithms.bubbleSort(list);
        Assert.assertEquals(expected, list);
    }

    @Test
    public void testMerge(){
        List<Integer> list1 = Collections.singletonList(1);
        List<Integer> list2 = Collections.emptyList();

        Assert.assertEquals(Collections.singletonList(1), SortingAlgorithms.merge(list1, list2));

        list1 = Collections.singletonList(1);
        list2 = Collections.singletonList(2);

        Assert.assertEquals(Arrays.asList(1,2), SortingAlgorithms.merge(list1, list2));

        list1 = Arrays.asList(1,2);
        list2 = Arrays.asList(2,3);

        Assert.assertEquals(Arrays.asList(1,2,2,3), SortingAlgorithms.merge(list1, list2));

        list1 = Arrays.asList(3,4,5);
        list2 = Arrays.asList(1,2,6);

        Assert.assertEquals(Arrays.asList(1,2,3,4,5,6), SortingAlgorithms.merge(list1, list2));
    }

    @Test
    public void testMergeSort(){
        List<Integer> list = Collections.singletonList(1);
        Assert.assertEquals(list, SortingAlgorithms.mergeSort(list));
    }

    @Test
    public void testMergeSort1(){
        List<Integer> list = Arrays.asList(2,1);
        Assert.assertEquals(Arrays.asList(1,2), SortingAlgorithms.mergeSort(list));
    }

    @Test
    public void testMergeSort2(){
        List<Integer> list = Arrays.asList(5,4,1,3,2);
        Assert.assertEquals(Arrays.asList(1,2,3,4,5), SortingAlgorithms.mergeSort(list));
    }

    @Test
    public void testMergeSort3(){
        List<Integer> list = Arrays.asList(10,9,8,1,0,3,4,-5);
        Assert.assertEquals(Arrays.asList(-5,0,1,3,4,8,9,10), SortingAlgorithms.mergeSort(list));
    }

    @Test
    public void testMergeSort4(){
        int[] arr = {};
        SortingAlgorithms.mergeSort(arr);
        Assert.assertEquals(0, arr.length);
    }

    @Test
    public void testMergeSort5(){
        int[] arr = {1};
        SortingAlgorithms.mergeSort(arr);
        IntStream.range(0,arr.length).forEach(i -> {Assert.assertEquals(arr[i], 1);});
    }

    @Test
    public void testMergeSort6(){
        int[] arr = {2,1};
        SortingAlgorithms.mergeSort(arr);
        IntStream.range(0,arr.length).forEach(i -> Assert.assertEquals(arr[i], i + 1));
    }

    @Test
    public void testMergeSort7(){
        int[] arr = {10,9,8};
        SortingAlgorithms.mergeSort(arr);
        IntStream.range(0,arr.length).forEach(i -> {Assert.assertEquals(arr[i], 8 + i);});
    }

    @Test
    public void testGetDigitAtPosition(){
        int num = 1234;
        Assert.assertEquals(4, SortingAlgorithms.getDigitAtPosition(num, 0));
        Assert.assertEquals(3, SortingAlgorithms.getDigitAtPosition(num, 1));
        Assert.assertEquals(2, SortingAlgorithms.getDigitAtPosition(num, 2));
        Assert.assertEquals(1, SortingAlgorithms.getDigitAtPosition(num, 3));
    }

    @Test
    public void testRadixSort(){
        List<Integer> array = new ArrayList<>(Arrays.asList(312, 52, 10));
        SortingAlgorithms.radixSort(array, 3);
        Assert.assertEquals(Arrays.asList(10, 52, 312), array);
    }

    @Test
    public void testRadixSort1(){
        List<Integer> array = new ArrayList<>(Arrays.asList(1000, 312, 52, 10, 1));
        SortingAlgorithms.radixSort(array, 4);
        Assert.assertEquals(Arrays.asList(1,10,52,312,1000), array);
    }

    @Test
    public void testSwap(){
        int[] arr = {2,1};
        SortingAlgorithms.swap(arr,0,1);
        Assert.assertTrue(arr[0] == 1);
        Assert.assertTrue(arr[1] == 2);
    }

    @Test
    public void testQuickSort(){
        int[] arr = {2,1};
        SortingAlgorithms.quickSort(arr,0,1);
        Assert.assertTrue(arr[0] == 1);
        Assert.assertTrue(arr[1] == 2);
    }

    @Test
    public void testQuickSort2(){
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        SortingAlgorithms.quickSort(arr,0,9);
        IntStream.range(0,10).forEach(i -> Assert.assertTrue(arr[i] == i+1));
    }

    @Test
    public void testInsertionSort(){
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        SortingAlgorithms.insertionSort(arr);
        IntStream.range(0,10).forEach(i -> Assert.assertTrue(arr[i] == i+1));
    }

    @Test
    public void testBucketSort(){
        List<Integer> array = new ArrayList<>(Arrays.asList(1000, 312, 52, 10, 1));
        SortingAlgorithms.bucketSort(array);
        Assert.assertEquals(Arrays.asList(1,10,52,312,1000), array);
    }
}
