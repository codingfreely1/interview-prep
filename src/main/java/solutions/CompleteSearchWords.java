package solutions;

import java.util.*;

/**
 * Created by yael on 17/02/17.
 */
public class CompleteSearchWords {

    static class Trie {
        public final static int maxCached = 3;
        TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        void addWord(String word){
            addWord(word, 0, root);
        }

        int addWord(String s, int inx, TrieNode node) {
            if(inx == s.length()) {
                node.frequency += 1;
                return node.frequency;
            }

            char cur = s.charAt(inx);
            TrieNode curNode = node.map.get(cur);
            if(curNode == null) {
                curNode = new TrieNode();
                node.map.put(cur, curNode);
            }
            int freq = addWord(s, inx+1, curNode);
            curNode.updateCache(s, freq);
            return freq;
        }

        Set<String> getCompletion(String prefix) {
            TrieNode cur = root;
            for(int i = 0; i< prefix.length(); i++) {
                char c = prefix.charAt(i);
                if(cur.map.get(c) == null) {
                    break;
                }
                cur = cur.map.get(c);
            }
            return cur.cache.keySet();
        }


    }

    static class TrieNode {

        int frequency;
        Map<Character, TrieNode> map;
        Map<String, Integer> cache;

        TrieNode( ){
            map = new HashMap<>();
            frequency = 0;
            cache = new HashMap<>();
        }

        public void updateCache(String s, int frequency) {

            if(cache.containsKey(s)){
                cache.put(s, frequency); //update freq.
                return;
            }

            String toRemove = null;
            int minFreq = Integer.MAX_VALUE;
            if(cache.size() >= Trie.maxCached){
                for(String cur : cache.keySet()){
                    if(cache.get(cur) < minFreq){
                            minFreq = cache.get(cur);
                            toRemove = cur;
                    }
                }
                if(frequency >= minFreq){
                    cache.remove(toRemove);
                    cache.put(s,frequency);
                }
            } else {
                cache.put(s, frequency);
            }
        }

    }
}
