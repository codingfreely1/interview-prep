package algorithms;

import algorithms.BitManipulation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yael on 31/12/16.
 */
public class BitManipulationTest {

    @Test
    public void testArithmeticShift(){
        Assert.assertEquals(BitManipulation.repeatedArithmeticShift(-93242, 40), -1);
    }

    @Test
    public void testLogicalShift(){
        Assert.assertEquals(BitManipulation.repeatedLogicalShift(-93242, 40), 0);
    }

    @Test
    public void testGetBit(){
        Assert.assertEquals(BitManipulation.getBit(1, 0), 1);

        Assert.assertEquals(BitManipulation.getBit(2, 0), 0);
        Assert.assertEquals(BitManipulation.getBit(2, 1), 1);

        Assert.assertEquals(BitManipulation.getBit(3, 0), 1);
        Assert.assertEquals(BitManipulation.getBit(3, 1), 1);
        Assert.assertEquals(BitManipulation.getBit(3, 2), 0);

        Assert.assertEquals(BitManipulation.getBit(8, 2), 0);
        Assert.assertEquals(BitManipulation.getBit(8, 3), 1);
    }

    @Test
    public void testGetBit_BookImplementation(){
        Assert.assertTrue(BitManipulation.getBit_BookImplementation(1, 0));

        Assert.assertFalse(BitManipulation.getBit_BookImplementation(2, 0));
        Assert.assertTrue(BitManipulation.getBit_BookImplementation(2, 1));

        Assert.assertTrue(BitManipulation.getBit_BookImplementation(3, 0));
        Assert.assertTrue(BitManipulation.getBit_BookImplementation(3, 1));
        Assert.assertFalse(BitManipulation.getBit_BookImplementation(3, 2));
    }

    @Test
    public void testSetBit(){
        Assert.assertEquals(BitManipulation.setBit(2,0), 3);
        Assert.assertEquals(BitManipulation.setBit(5,1), 7);
    }

    @Test
    public void testClearBit(){
        Assert.assertEquals(BitManipulation.clearBit(3,0), 2);
        Assert.assertEquals(BitManipulation.clearBit(8,3), 0);
    }

    @Test
    public void testUpdateBit(){
        Assert.assertEquals(BitManipulation.updateBit(2, 0, true), 3);
    }

}
