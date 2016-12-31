import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yael on 31/12/16.
 */
public class SortingAlgorithmsTest {

    @Test
    public void testBubbleSort(){
        List<Comparable> list = Arrays.asList(10,9,1,8,0);
        List<Comparable> expected = Arrays.asList(0,1,8,9,10);

        SortingAlgorithms.bubbleSort(list);
        Assert.assertEquals(expected, list);
    }

    @Test
    public void testBubbleSort2(){
        List<Comparable> list = Arrays.asList(10,9,8,7,6,5,4,3,2,1,0);
        List<Comparable> expected = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);

        SortingAlgorithms.bubbleSort(list);
        Assert.assertEquals(expected, list);
    }

}
