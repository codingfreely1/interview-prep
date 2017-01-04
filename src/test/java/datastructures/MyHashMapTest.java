package datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by yael on 04/01/17.
 */
public class MyHashMapTest {

    @Test
    public void testMyHashMap(){
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        Entry<Integer, String> entry1 = new Entry<>(1, "one");
        Entry<Integer, String> entry2 = new Entry<>(1, "another one");
        Entry<Integer, String> entry3 = new Entry<>(11, "same list");
        Entry<Integer, String> entry4 = new Entry<>(22, "twenty two");

        Assert.assertEquals(myHashMap.size(), 0);
        myHashMap.put(entry1.getKey(), entry1.getValue());
        Assert.assertEquals(myHashMap.size(), 1);
        Assert.assertEquals(myHashMap.get(entry1.getKey()), entry1.getValue());
        Assert.assertNull(myHashMap.get(50));

        myHashMap.put(entry2.getKey(), entry2.getValue());
        Assert.assertEquals(myHashMap.size(), 1);
        Assert.assertEquals(myHashMap.get(entry2.getKey()), entry2.getValue());

        myHashMap.put(entry3.getKey(), entry3.getValue());
        Assert.assertEquals(myHashMap.size(), 2);
        Assert.assertEquals(myHashMap.get(entry3.getKey()), entry3.getValue());

        myHashMap.put(entry4.getKey(), entry4.getValue());
        Assert.assertEquals(myHashMap.size(), 3);
        Assert.assertEquals(myHashMap.get(entry4.getKey()), entry4.getValue());

        myHashMap.remove(entry3.getKey());
        Assert.assertEquals(myHashMap.size(), 2);
        Assert.assertNull(myHashMap.get(entry3.getKey()));
        Assert.assertEquals(myHashMap.get(entry2.getKey()), entry2.getValue());

        Assert.assertTrue(myHashMap.containsKey(entry2.getKey()));
        Assert.assertTrue(myHashMap.containsValue(entry2.getValue()));
    }

    @Test
    public void testPutAll(){
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        Map<Integer, String> input = new HashMap<>();
        IntStream.range(0,5).forEach(i -> input.put(i, String.valueOf(i)));
        myHashMap.putAll(input);
        Assert.assertEquals(myHashMap.size(), 5);
        IntStream.range(0,5).forEach(i -> Assert.assertEquals(myHashMap.get(i), String.valueOf(i)));
    }

}
