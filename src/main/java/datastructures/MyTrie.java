package datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yael on 03/01/17.
 */
public class MyTrie {

    private TrieNode root;

    private class TrieNode {
        private char curChar;//Not really using this.. maybe for printing..
        private boolean isValid;
        private Map<Character, TrieNode> chars;

        public TrieNode(char curChar, boolean isValid ){
            this.curChar = curChar;
            this.isValid = isValid;
            this.chars = new HashMap<>();
        }

        private TrieNode addChar(Character c, boolean isValid) {
            TrieNode trieNode = getChar(c);
            if (trieNode == null) {
                trieNode =new TrieNode(c, isValid);
            } else{
                trieNode.isValid = trieNode.isValid | isValid; //
            }
            chars.put(c, trieNode);
            return trieNode;
        }

        private TrieNode getChar(Character c) {
            return chars.get(c);
        }
    }

    public MyTrie(){
        root = new TrieNode('-', true);
    }

    public void addWord(String s) {
        char curChar;
        TrieNode curNode = root;
        for(int i = 0; i < s.length(); i++) {
            curChar = s.charAt(i);
            curNode = curNode.addChar(curChar,  i == (s.length()-1));
        }
    }

    public boolean isValidWord(String s) {
        char curChar;
        TrieNode curNode = root;
        for(int i = 0; i < s.length(); i++) {
            curChar = s.charAt(i);
            curNode = curNode.getChar(curChar);
            if(curNode == null){
                return false;
            }
        }
        return curNode.isValid;
    }

}