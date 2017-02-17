package solutions;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by yael on 09/02/17.
 */
public class Chapter17Test {

    @Test
    public void testWordTransformer(){
        Set<String> dict = new HashSet<>();
        dict.add("why");
        dict.add("hhy");
        dict.add("hoy");
        dict.add("how");
        dict.add("wow");

        List<String> l =  Chapter17.getTransformSteps("why", "how", dict);
        System.out.println(l);
    }


    @Test
    public void testWordTransformer2(){
        Set<String> dict = new HashSet<>();
        dict.add("dump");
        dict.add("ramp");
        dict.add("lamp");
        dict.add("limp");
        dict.add("lime");
        dict.add("like");

        List<String> l =  Chapter17.getTransformSteps("damp", "like", dict);
        System.out.println(l);
    }

    @Test
    public void testFindWordIndexes(){
        Chapter17 solution = new Chapter17();
        String[] words = {"i","is"};
        Map<String, List<Integer>> res = solution.findWordIndexes("mississippi", words);
        Map<String, List<Integer>> expected = new HashMap<>();
        expected.put("i", Arrays.asList(1,4,7,10));
        expected.put("is", Arrays.asList(1, 4));

        Assert.assertEquals(expected, res);
    }

    @Test
    public void testMinRange(){
        int[] bigArray = {7, 1, 6, 5, 9, 1};
        int[] smallArray = {1,5, 9};
        Assert.assertEquals(new Chapter17.Range(3, 5), Chapter17.findSmalestSubArray(bigArray, smallArray));

        int[] bigArray2 = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        Assert.assertEquals(new Chapter17.Range(7, 10), Chapter17.findSmalestSubArray(bigArray2, smallArray));
    }
}
