package algorithms;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yael on 31/12/16.
 */
public class ArraysAndStringsTest {

    @Test
    public void testIsUnique(){
        Assert.assertTrue(ArraysAndStrings.isUnique("abcdefghijklmnop"));
        Assert.assertFalse(ArraysAndStrings.isUnique("abcdefghijklmnopa"));
    }

    @Test
    public void testIsUniqueWithBitVector(){
        Assert.assertTrue(ArraysAndStrings.isUniqueUsingBitVector("abcdefghijklmnopz"));
        Assert.assertFalse(ArraysAndStrings.isUniqueUsingBitVector("abcdefghijdklmsnopz"));
    }

    @Test
    public void testIsUniqueUsingSort(){
        Assert.assertTrue(ArraysAndStrings.isUniqueUsingSort("abcdefghijklmnopz"));
        Assert.assertFalse(ArraysAndStrings.isUniqueUsingSort("abcdefghijklmnopaz"));
    }

    @Test
    public void testIsUniqueBookSol(){
        Assert.assertTrue(ArraysAndStrings.isUniqueBookSolution("abcdefghijklmnopz"));
        Assert.assertFalse(ArraysAndStrings.isUniqueBookSolution("abcdefghijklmnopaz"));
    }

}
