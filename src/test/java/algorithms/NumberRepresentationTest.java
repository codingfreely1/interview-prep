package algorithms;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yael on 17/01/17.
 */
public class NumberRepresentationTest {

    @Test
    public void fromDecimalToBaseTest(){
        Assert.assertEquals("1000", NumberRepresentation.convertDecimalToBase(2, 8));
        Assert.assertEquals("10", NumberRepresentation.convertDecimalToBase(16, 16));
        Assert.assertEquals("1F", NumberRepresentation.convertDecimalToBase(16, 31));
    }

    @Test
    public void fromBaseToDecimalTest(){
        Assert.assertEquals(8, NumberRepresentation.fromBaseToDecimal("1000", 2));
        Assert.assertEquals(16, NumberRepresentation.fromBaseToDecimal("10", 16));
        Assert.assertEquals(31, NumberRepresentation.fromBaseToDecimal("1F", 16));
    }

    @Test
    public void convertTwsComplementToDecimalTest(){
        Assert.assertEquals(3, NumberRepresentation.convertTwsComplementToDecimal("011"));
        Assert.assertEquals(2, NumberRepresentation.convertTwsComplementToDecimal("010"));
        Assert.assertEquals(1, NumberRepresentation.convertTwsComplementToDecimal("001"));
        Assert.assertEquals(0, NumberRepresentation.convertTwsComplementToDecimal("000"));
        Assert.assertEquals(-1, NumberRepresentation.convertTwsComplementToDecimal("111"));
        Assert.assertEquals(-2, NumberRepresentation.convertTwsComplementToDecimal("110"));
        Assert.assertEquals(-3, NumberRepresentation.convertTwsComplementToDecimal("101"));
        Assert.assertEquals(-4, NumberRepresentation.convertTwsComplementToDecimal("100"));
        Assert.assertEquals(2, NumberRepresentation.convertTwsComplementToDecimal("00000010"));
        Assert.assertEquals(-1, NumberRepresentation.convertTwsComplementToDecimal("11111111"));
        Assert.assertEquals(-127, NumberRepresentation.convertTwsComplementToDecimal("10000001"));
        Assert.assertEquals(-128, NumberRepresentation.convertTwsComplementToDecimal("10000000"));
    }

    @Test
    public void convertDecimalToTwosComplementTest(){
        Assert.assertEquals("011", NumberRepresentation.convertDecimalToTwosComplement(3, 3));
        Assert.assertEquals("010", NumberRepresentation.convertDecimalToTwosComplement(2, 3));
        Assert.assertEquals("001", NumberRepresentation.convertDecimalToTwosComplement(1, 3));
        Assert.assertEquals("000", NumberRepresentation.convertDecimalToTwosComplement(0, 3));
        Assert.assertEquals("111", NumberRepresentation.convertDecimalToTwosComplement(-1, 3));
        Assert.assertEquals("110", NumberRepresentation.convertDecimalToTwosComplement(-2, 3));
        Assert.assertEquals("101", NumberRepresentation.convertDecimalToTwosComplement(-3, 3));
        Assert.assertEquals("100", NumberRepresentation.convertDecimalToTwosComplement(-4, 3));
        Assert.assertEquals("10000001", NumberRepresentation.convertDecimalToTwosComplement(-127,8));
        Assert.assertEquals("10000000", NumberRepresentation.convertDecimalToTwosComplement(-128, 8));
    }
}
