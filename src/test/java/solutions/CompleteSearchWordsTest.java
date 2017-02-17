package solutions;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by yael on 17/02/17.
 */
public class CompleteSearchWordsTest {

    @Test
    public void testWordCompletion(){
        CompleteSearchWords.Trie trie = new CompleteSearchWords.Trie();
        trie.addWord("ab");

        Set<String> expected = new HashSet<>(Arrays.asList("ab"));
        Assert.assertEquals(expected, trie.getCompletion("a"));

        trie.addWord("abc");
        trie.addWord("abd");
        trie.addWord("abe");
        expected = new HashSet<>(Arrays.asList("abd", "abc", "abe"));
        Set<String> actual = trie.getCompletion("a");
        Assert.assertEquals(expected, actual);

        trie.addWord("ab");
        expected = new HashSet<>( Arrays.asList("ab", "abc", "abe"));
        actual = trie.getCompletion("a");
        Assert.assertEquals(expected, actual);

        trie.addWord("ab");
        trie.addWord("abf");
        actual = trie.getCompletion("a");
        expected = new HashSet<>(Arrays.asList("ab", "abf", "abe"));
        Assert.assertEquals(expected, actual);

        trie.addWord("abf");
        actual = trie.getCompletion("a");
        expected = new HashSet<>(Arrays.asList("ab", "abf", "abe"));
        Assert.assertEquals(expected, actual);

        Assert.assertEquals(Collections.EMPTY_SET, trie.getCompletion("b"));

    }
}
