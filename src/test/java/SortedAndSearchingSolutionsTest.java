import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yael on 01/01/17.
 */
public class SortedAndSearchingSolutionsTest {

    @Test
    public void testSortedMerge(){
        List<Integer> a = new ArrayList<>(Arrays.asList(0,2,6,7,9,-1,-1,-1));
        List<Integer> b = new ArrayList<>(Arrays.asList(1,5,10));

        SortingAndSearchingSolutions.mergeBIntoA(a,b);
        Assert.assertEquals(Arrays.asList(0,1,2,5,6,7,9,10), a);
    }

    @Test
    public void testSortedMerge2(){
        int[] a = {0,2,6,7,9,-1,-1,-1};
        int[] b = {1,5,10};
        int[] expected = {0,1,2,5,6,7,9,10};

        SortingAndSearchingSolutions.mergeBIntoA(a,b);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], a[i]);
        }
    }

}
