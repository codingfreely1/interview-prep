package solutions;

import datastructures.Listy;
import org.junit.Assert;
import org.junit.Test;
import solutions.SortingAndSearchingSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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

    @Test
    public void testFindDuplicates(){
        int[] arr = {1,3003, 8, 1050, 1, 32000, 32000};
        SortingAndSearchingSolutions.findDuplicates(arr);
    }

    @Test
    public void testSortSearchNoSize(){
        Listy listy = new Listy(Arrays.asList(1,2,3));
        int i = SortingAndSearchingSolutions.sortedSearchNoSize(listy, 2);
        Assert.assertEquals(1,i);

        listy = new Listy(Collections.emptyList());
        i = SortingAndSearchingSolutions.sortedSearchNoSize(listy, 2);
        Assert.assertEquals(-1,i);

        int limit = (int)Math.pow(2, 16) * 3;

        Listy finalListy = new Listy(Collections.emptyList());
        IntStream.range(0, limit).forEach(j -> finalListy.getArrayList().add(j));
        i = SortingAndSearchingSolutions.sortedSearchNoSize(finalListy, 70000);
        Assert.assertEquals(70000,i);
    }
}
