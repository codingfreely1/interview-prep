package solutions;

import model.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yael on 11/01/17.
 */
public class InterviewQuestionsSolutionsTest {

    @Test
    public void testGetCentury() {
        Assert.assertEquals("19th", InterviewQuestionsSolutions.getFormattedCenturyString("1900"));
        Assert.assertEquals("20th", InterviewQuestionsSolutions.getFormattedCenturyString("1901"));
        Assert.assertEquals("21st", InterviewQuestionsSolutions.getFormattedCenturyString("2012"));
    }

    @Test
    public void testToLowerCaseWithUnderscore(){
        Assert.assertEquals("test7_boo", InterviewQuestionsSolutions.toLowerCaseWithUnderscoreDelimiter("Test7Boo"));
        Assert.assertEquals("", InterviewQuestionsSolutions.toLowerCaseWithUnderscoreDelimiter(""));
    }

    @Test
    public void testSubsetOfSum() {
        int[] arr = {2, 9, 4, 7};

        Assert.assertTrue(InterviewQuestionsSolutions.isSubsetEqualsToSumExist(arr, 15));
        Assert.assertFalse(InterviewQuestionsSolutions.isSubsetEqualsToSumExist(arr, 1));

        int[] arr2 = {2};
        Assert.assertTrue(InterviewQuestionsSolutions.isSubsetEqualsToSumExist(arr2, 2));
        Assert.assertFalse(InterviewQuestionsSolutions.isSubsetEqualsToSumExist(arr2, 4));

        int[] arr3 = {2,3};
        Assert.assertTrue(InterviewQuestionsSolutions.isSubsetEqualsToSumExist(arr3, 3));
        Assert.assertFalse(InterviewQuestionsSolutions.isSubsetEqualsToSumExist(arr3, 1));

        int[] arr4 = {2, 9, 4, -1};
        Assert.assertTrue(InterviewQuestionsSolutions.isSubsetEqualsToSumExist(arr4, 1));
        Assert.assertFalse(InterviewQuestionsSolutions.isSubsetEqualsToSumExist(arr4, 100));

    }

    @Test
    public void testFindPairMatchSumInOrderedArray(){
        int[] arr = {2, 9, 10, 22, 56, 78};

        Pair<Integer, Integer> pair = InterviewQuestionsSolutions.findPairMatchSumInOrderedArray(arr, 1);
        Assert.assertNull(pair);

        pair = InterviewQuestionsSolutions.findPairMatchSumInOrderedArray(arr, 101);
        Assert.assertNull(pair);

        pair = InterviewQuestionsSolutions.findPairMatchSumInOrderedArray(arr, 32);
        Pair<Integer, Integer> expected = new Pair<>(2,3);
        Assert.assertEquals(expected,pair);

        int[] arr2 = {-50, -22, 0, 2, 9, 10, 22, 56, 78};
        pair = InterviewQuestionsSolutions.findPairMatchSumInOrderedArray(arr2, 0);
        expected = new Pair<>(1,6);
        Assert.assertEquals(expected,pair);
    }

    @Test
    public void testFindPairMatchSumInUnOrderedArray(){
        int[] arr = {2, 9, 22, 56, 10, 78};
        Pair<Integer, Integer> pair = InterviewQuestionsSolutions.findPairMatchSumInUnsortedArray(arr, 1);
        Assert.assertNull(pair);
        pair = InterviewQuestionsSolutions.findPairMatchSumInUnsortedArray(arr, 32);
        Pair<Integer, Integer> expected = new Pair<>(2,4);
        Assert.assertEquals(expected,pair);
    }

    @Test
    public void testIsAllFile(){
        Assert.assertFalse(InterviewQuestionsSolutions.isAllFile(Arrays.asList(new InterviewQuestionsSolutions.Interval(3,6),
                new InterviewQuestionsSolutions.Interval(0,0),
                new InterviewQuestionsSolutions.Interval(2,4),
                new InterviewQuestionsSolutions.Interval(6,7)), 8));

        Assert.assertTrue(InterviewQuestionsSolutions.isAllFile(Arrays.asList(new InterviewQuestionsSolutions.Interval(3,6),
                new InterviewQuestionsSolutions.Interval(0,1),
                new InterviewQuestionsSolutions.Interval(2,4),
                new InterviewQuestionsSolutions.Interval(6,7)), 8));
    }
}
