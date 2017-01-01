import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yael on 31/12/16.
 */
public class SortingAlgorithmsTest {

    @Test
    public void testBubbleSort(){
        List<Comparable> list = Arrays.asList(10,9,1,8,0);
        List<Comparable> expected = Arrays.asList(0,1,8,9,10);

        SortingAlgorithms.bubbleSort(list);
        Assert.assertEquals(expected, list);
    }

    @Test
    public void testBubbleSort2(){
        List<Comparable> list = Arrays.asList(10,9,8,7,6,5,4,3,2,1,0);
        List<Comparable> expected = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);

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

}
