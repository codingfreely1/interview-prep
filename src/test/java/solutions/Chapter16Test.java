package solutions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yael on 19/01/17.
 */
public class Chapter16Test {

    @Test
    public void testMaxContiguousSum(){
        int arr[] = {2, -8, 3, -2, 4, -10};
        Assert.assertEquals( 5, Chapter16.findMaxContiguousSum(arr));
    }

    @Test
    public void testSubSort(){
        int[] arr = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        int[] res = Chapter16.subSort(arr);
        Assert.assertEquals(3, res[0]);
        Assert.assertEquals(9, res[1]);
    }

    @Test
    public void testFactorialZeros(){
        System.out.println(Chapter16.countFactZeros2(100));
    }

    @Test
    public void testComputeEquation(){
        String eq = "1+3";
        Assert.assertEquals(4, Chapter16.compute(eq));
        eq = "1+3*5-6";
        Assert.assertEquals(10, Chapter16.compute(eq));
    }

    @Test
    public void testCalculate(){
        String eq = "1+3";
        Assert.assertEquals(4, Chapter16.calculate(eq).intValue());
        eq = "1+3*5-6";
        Assert.assertEquals(10, Chapter16.calculate(eq).intValue());
        eq = "1+3*5-6/2";
        Assert.assertEquals(13, Chapter16.calculate(eq).intValue());
        eq = "1+3.0*5-6/2";
        Assert.assertEquals(13, Chapter16.calculate(eq).intValue());
        eq = "1";
        Assert.assertEquals(1, Chapter16.calculate(eq).intValue());
        eq = "5-3";
        Assert.assertEquals(2, Chapter16.calculate(eq).intValue());
        eq = "-1-1";
        Assert.assertEquals(-2, Chapter16.calculate(eq).intValue());
    }

    @Test
    public void testPatternMaching(){
        String value = "catcat";
        String pattern = "aa";
        Assert.assertTrue(Chapter16.patternMatching(pattern, value));

        value = "catcatgo";
        pattern = "aab";
        Assert.assertTrue(Chapter16.patternMatching(pattern, value));

        value = "catcatgo";
        pattern = "aabb";
        Assert.assertFalse(Chapter16.patternMatching(pattern, value));

        value = "cd";
        pattern = "a";
        Assert.assertTrue(Chapter16.patternMatching(pattern, value));

        value = "c";
        pattern = "ab";
        Assert.assertTrue(Chapter16.patternMatching(pattern, value));//b matches empty string

        value = "c";
        pattern = "aab";
        Assert.assertTrue(Chapter16.patternMatching(pattern, value));//a matches empty string

        value = "ccc";
        pattern = "aab";
        Assert.assertTrue(Chapter16.patternMatching(pattern, value));//is this the right behaviour ? can a equal b ?
    }
}
