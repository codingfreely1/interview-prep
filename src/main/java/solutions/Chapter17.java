package solutions;

import org.junit.Assert;

import java.util.*;

/**
 * Created by yael on 09/02/17.
 */
public class Chapter17 {
    private static Set<String> visited = new HashSet<>();

    public static LinkedList<String> getTransformSteps(String s, String d, Set<String> dict) {
        Assert.assertEquals(s.length(), d.length());

        Queue<String> queue = new LinkedList<>();

        if(s.isEmpty()) {
            return new LinkedList<>();
        }
        if(s.equals(d)) {
            return new LinkedList<>(Collections.singleton(s));
        }
        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String cur = queue.remove(); //first
            List<String> oneLetterWildCards = getWildCard(cur);
            for (String wildCard : oneLetterWildCards) {
                List<String> neighbors = getNeighbors(wildCard, dict);
                for (String n : neighbors) {
                    if (!visited.contains(n)) {
                        visited.add(n);
                        queue.add(n);
                        LinkedList<String> path = getTransformSteps(n, d, dict);
                        if (path != null && !path.isEmpty()) {
                            path.addFirst(s);
                            return path;
                        }
                    }
                }
            }
        }
        return new LinkedList<>();
    }

    private static List<String> getWildCard(String s ){
        List<String> wildCards = new ArrayList<>();
        for(int i = 0;  i < s.length() ; i++){
            wildCards.add(s.substring(0,i) +'_' + s.substring(i+1, s.length()));
        }
        return wildCards;
    }

    private static List<String> getNeighbors(String wildCard, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        boolean toAdd;
        for(String word:dict) {
            toAdd = true;
            for(int i = 0; i< wildCard.length(); i++){
                if( (wildCard.charAt(i) != '_') && (wildCard.charAt(i) != word.charAt(i)) ) {
                    toAdd = false;
                    break;
                }
            }
            if(toAdd) {
                neighbors.add(word);
            }
        }
        return neighbors;
    }

    public Map<String, List<Integer>> findWordIndexes(String b, String[] words){
        TrieNode trie = createTrie(words);

        Map<String, List<Integer>> map = new HashMap<>();

        TrieNode cur;
        for(int i = 0; i < b.length(); i++){
            cur  = trie;
            int offset = 0;
            cur = cur.getNext(b.charAt(i + offset));
            while(cur != null) {
                offset++;
                if(cur.isValidEnd) {
                    List<Integer> list = map.get(cur.word);
                    if(list == null) {
                        list  = new ArrayList<>();
                        map.put(cur.word, list);
                    }
                    list.add(i);
                }
                if(i+offset < b.length()) {
                    cur = cur.getNext(b.charAt(i + offset));
                } else {
                   break;
                }

            }
        }
        return map;
    }

    class TrieNode{
        String word;
        Map<Character, TrieNode> children;
        boolean isValidEnd;

        TrieNode(String word) {
            this.word = word;
            this.children = new HashMap<>();
            this.isValidEnd = false;
        }

        void addWord(String word){
            TrieNode cur = this;
            for(int i = 0; i<word.length(); i++){
                cur = cur.addChild(word.charAt(i));
            }
            cur.isValidEnd = true;
        }

        private TrieNode addChild(char c) {
            TrieNode n = children.get(c);
            if(n == null) {
                n = new TrieNode(this.word + c);
                children.put(c,n);
            }
            return n;
        }

        TrieNode getNext(char c) {
            return children.get(c);
        }
    }

    private TrieNode createTrie(String[] words) {
        TrieNode root = this.new TrieNode("");
        for(String w : words) {
            root.addWord(w);
        }
        return root;
    }
}
