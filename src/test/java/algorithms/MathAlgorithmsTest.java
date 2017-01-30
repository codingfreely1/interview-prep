package algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

/**
 * Created by yael on 15/01/17.
 */
public class MathAlgorithmsTest {

    @Test
    public void testRecursiveFactorial(){
        testFactorial(MathAlgorithms::calcFactorial);
    }

    @Test
    public void testIterativeFactorial(){
        testFactorial(MathAlgorithms::calcFactorialIteratively);
    }

    private void testFactorial(Function<Integer,Long> function){
        Assert.assertEquals(1, function.apply(0).intValue());
        Assert.assertEquals(1, function.apply(1).intValue());
        Assert.assertEquals(2, function.apply(2).intValue());
        Assert.assertEquals(6, function.apply(3).intValue());
        Assert.assertEquals(24, function.apply(4).intValue());
        Assert.assertEquals(120, function.apply(5).intValue());
        Assert.assertEquals(479001600, function.apply(12).intValue());
    }

    @Test
    public void testNChooseK(){
        Assert.assertEquals(6*5/2, MathAlgorithms.calcNchooseK(6, 2));
    }

    @Test
    public void testIsPowerOfTwo(){
        Assert.assertTrue(MathAlgorithms.isPowerOfTwoBitOperation(1));
        Assert.assertTrue(MathAlgorithms.isPowerOfTwoBitOperation(2));
        Assert.assertTrue(MathAlgorithms.isPowerOfTwoBitOperation(4));
        Assert.assertTrue(MathAlgorithms.isPowerOfTwoBitOperation(8));

        Assert.assertFalse(MathAlgorithms.isPowerOfTwoBitOperation(0));
        Assert.assertFalse(MathAlgorithms.isPowerOfTwoBitOperation(3));
        Assert.assertFalse(MathAlgorithms.isPowerOfTwoBitOperation(5));
        Assert.assertFalse(MathAlgorithms.isPowerOfTwoBitOperation(6));
    }
}
