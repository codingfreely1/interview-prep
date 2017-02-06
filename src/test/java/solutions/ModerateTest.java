package solutions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yael on 19/01/17.
 */
public class ModerateTest {

    @Test
    public void testMaxContiguousSum(){
        int arr[] = {2, -8, 3, -2, 4, -10};
        Assert.assertEquals( 5,Moderate.findMaxContiguousSum(arr));
    }

    @Test
    public void testSubSort(){
        int[] arr = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        int[] res = Moderate.subSort(arr);
        Assert.assertEquals(3, res[0]);
        Assert.assertEquals(9, res[1]);
    }

    @Test
    public void testFactorialZeros(){
        System.out.println(Moderate.countFactZeros2(100));
    }

    @Test
    public void testComputeEquation(){
        String eq = "1+3";
        Assert.assertEquals(4, Moderate.compute(eq));
        eq = "1+3*5-6";
        Assert.assertEquals(10, Moderate.compute(eq));
    }

    @Test
    public void testCalculate(){
        String eq = "1+3";
        Assert.assertEquals(4, Moderate.calculate(eq).intValue());
        eq = "1+3*5-6";
        Assert.assertEquals(10, Moderate.calculate(eq).intValue());
        eq = "1+3*5-6/2";
        Assert.assertEquals(13, Moderate.calculate(eq).intValue());
        eq = "1+3.0*5-6/2";
        Assert.assertEquals(13, Moderate.calculate(eq).intValue());
        eq = "1";
        Assert.assertEquals(1, Moderate.calculate(eq).intValue());
        eq = "5-3";
        Assert.assertEquals(2, Moderate.calculate(eq).intValue());
        eq = "-1-1";
        Assert.assertEquals(-2, Moderate.calculate(eq).intValue());
    }

}
