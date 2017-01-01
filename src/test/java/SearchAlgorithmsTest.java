import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by yael on 30/12/16.
 */
public class SearchAlgorithmsTest {

    @Test
    public void testBinarySearch1(){
        ArrayList<Integer> arr = new ArrayList<>();
        Assert.assertFalse(SearchAlgorithms.binarySearch(arr, 3));

        arr.add(3);
        Assert.assertTrue(SearchAlgorithms.binarySearch(arr, 3));
        Assert.assertFalse(SearchAlgorithms.binarySearch(arr, 4));

        arr.add(4);
        Assert.assertTrue(SearchAlgorithms.binarySearch(arr, 3));
        Assert.assertTrue(SearchAlgorithms.binarySearch(arr, 4));
    }

    @Test
    public void testBinarySearch2(){
        ArrayList<Integer> arr = new ArrayList<>();
        Assert.assertEquals(SearchAlgorithms.binarySearch(arr, 3, 0, arr.size()), -1);

        arr.add(3);
        Assert.assertEquals(SearchAlgorithms.binarySearch(arr, 3, 0, arr.size()), 0);

        arr.add(4);
        Assert.assertEquals(SearchAlgorithms.binarySearch(arr, 3, 0, arr.size()), 0);
        Assert.assertEquals(SearchAlgorithms.binarySearch(arr, 4, 0, arr.size()), 1);

        arr.add(5);
        arr.add(6);
        arr.add(7);
        Assert.assertEquals(SearchAlgorithms.binarySearch(arr, 3, 0, arr.size()), 0);
        Assert.assertEquals(SearchAlgorithms.binarySearch(arr, 4, 0, arr.size()), 1);
        Assert.assertEquals(SearchAlgorithms.binarySearch(arr, 5, 0, arr.size()), 2);
        Assert.assertEquals(SearchAlgorithms.binarySearch(arr, 6, 0, arr.size()), 3);
        Assert.assertEquals(SearchAlgorithms.binarySearch(arr, 7, 0, arr.size()), 4);
    }

    @Test
    public void testBinarySearch3(){
        int[] arr = {0,1,2,3,4};
        Assert.assertEquals(-1, SearchAlgorithms.binarySearch(arr, 5));
        Assert.assertEquals(2, SearchAlgorithms.binarySearch(arr, 2));
        Assert.assertEquals(4, SearchAlgorithms.binarySearch(arr, 4));

        int[] arr2 = {4,10,12,55};
        Assert.assertEquals(2, SearchAlgorithms.binarySearch(arr2, 12));
    }
}
