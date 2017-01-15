package solutions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yael on 15/01/17.
 */
public class MathSolutionsTest {

    @Test
    public void testNumberOfHandshakesBetweenNPeople(){
        Assert.assertEquals(0, MathSolutions.numberOfHandShakes(0));
        Assert.assertEquals(0, MathSolutions.numberOfHandShakes(1));
        Assert.assertEquals(1, MathSolutions.numberOfHandShakes(2));
        Assert.assertEquals(3, MathSolutions.numberOfHandShakes(3));
    }
}
