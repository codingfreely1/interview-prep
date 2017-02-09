package solutions;

import model.Range;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yael on 04/02/17.
 */
public class ArraysSolutionsTest {

    @Test
    public void testLongestIncreasingRange(){
        int[] arr = {1,2,3,2,4,5,10,7};
        Assert.assertEquals(new Range(3, 6), ArraysSolutions.findLongestIncreasingRange(arr));

        int[] arr2 = {-1,0,-3,-5};
        Assert.assertEquals(new Range(0, 1), ArraysSolutions.findLongestIncreasingRange(arr2));

        int[] arr3 = {1, 3, 2, 3, 4, 8, 7, 9};
        Assert.assertEquals(new Range(2, 5), ArraysSolutions.findLongestIncreasingRange(arr3));
    }

    @Test
    public void testIsCircularArray(){
        int[] arr2 = {2,-1,2};
        Assert.assertTrue(ArraysSolutions.isCircularArray(arr2));

        int[] arr3 = {1, 1, -1};
        Assert.assertFalse(ArraysSolutions.isCircularArray(arr3));

        int[] arr4 = {-1, -1, -1};
        Assert.assertTrue(ArraysSolutions.isCircularArray(arr4));

        int[] arr = {1,2,3,2,4,5,10,7};
        Assert.assertFalse(ArraysSolutions.isCircularArray(arr));
    }
}
