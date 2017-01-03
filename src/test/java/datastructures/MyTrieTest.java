package datastructures;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yael on 03/01/17.
 */
public class MyTrieTest {

    @Test
    public void testTrie(){
        MyTrie myTrie = new MyTrie();
        String word = "";
        myTrie.addWord(word);
        Assert.assertTrue(myTrie.isValidWord(word));

        word = "b";
        Assert.assertFalse(myTrie.isValidWord(word));

        word = "apple";
        myTrie.addWord(word);
        Assert.assertTrue(myTrie.isValidWord(word));

        word = "under";
        myTrie.addWord(word);
        Assert.assertTrue(myTrie.isValidWord(word));

        word = "underdog";
        myTrie.addWord(word);
        Assert.assertTrue(myTrie.isValidWord(word));

        word = "under";//making sure the sub word was not affected.
        Assert.assertTrue(myTrie.isValidWord(word));
    }
}
