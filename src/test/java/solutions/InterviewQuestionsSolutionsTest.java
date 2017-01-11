package solutions;

import org.junit.Assert;
import org.junit.Test;

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
}
