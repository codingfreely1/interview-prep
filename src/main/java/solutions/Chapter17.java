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

    //// q 17.18
    public static Range findSmalestSubArray(int[] bigArray, int[] smallArray) {
        List<List<Integer>> indexesPerItemInSmall = findIndexes(bigArray, smallArray);

        return findRange(indexesPerItemInSmall);
    }

    private static List<List<Integer>> findIndexes(int[] bigArray, int[] smallArray) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i< smallArray.length ; i++ ) {
            List<Integer> list = new ArrayList<>();
            int value = smallArray[i];
            for(int j = 0 ; j< bigArray.length ; j++ ) {
                if(bigArray[j] == value) {
                    list.add(j);
                }
            }
            res.add(list);
        }
        return res;
    }

    static class HeapNode implements Comparable<HeapNode> {
        int value;
        int originListId;

        HeapNode(int value, int originListId) {
            this.value = value;
            this.originListId = originListId;
        }

        @Override
        public int compareTo(HeapNode heapNode) {
            return value - heapNode.value;
        }
    }

    static class Range {
        int start;
        int end;

        Range(int start, int end){
            this.start = start;
            this.end = end;
        }
        int length(){
            return end - start +1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Range range = (Range) o;

            if (start != range.start) return false;
            return end == range.end;
        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }
    }

    private static Range findRange(List<List<Integer>> indexes) {
        Range range = null;
        int maxInx = Integer.MIN_VALUE;
        PriorityQueue<HeapNode> heap = new PriorityQueue<>();

        //initialize heap with an element from each list.
        for(int i = 0; i <  indexes.size(); i++ ) {
            List<Integer> list = indexes.get(i);
            if(list.isEmpty()){
                return null; //there is an element in small arr that has no index in big array.
            }
            int inx = list.remove(0);
            heap.add(new HeapNode(inx, i));
            if(inx > maxInx) {
                maxInx = inx;
            }
        }


        while(!heap.isEmpty()) {
            HeapNode min = heap.remove();
            int curRangeSize = maxInx - min.value + 1;
            if(range == null || curRangeSize < range.length() ){
                range  = new Range(min.value, maxInx);
            }

            int listId = min.originListId;
            List<Integer> originList = indexes.get(listId);
            if(originList.isEmpty()){
                return range;
            }

            int nextInx = originList.remove(0);
            if(nextInx > maxInx) {
                maxInx = nextInx;
            }
            heap.add(new HeapNode(nextInx, listId));
        }

        return null;

    }

    //// q 17.18
}
