package solutions.hackerrank;

/**
 * Created by yael on 17/01/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Solving hackerrank challenge: https://www.hackerrank.com/challenges/contacts
 * supporting two functions:
 1. add new contact
 2. find number of contacts starting with prefix and print the count on a new line.
 sample input:
 4
 add hack
 add hackerrank
 find hac
 find hak

 sample output:
 2
 0
 */
public class Contacts {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Trie trie = new Trie();
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        for(int i = 0; i<n ; i++ ){
            String line = sc.nextLine();
            String[] s = line.split(" ");
            String command = s[0];
            String arg = s[1];
            if(command.equals("add")){
                trie.addWord(arg);
            } else if(command.equals("find")){
                System.out.println(trie.findNumWordsForPrefix(arg));
            }
        }
    }

    static class Trie {

        private TrieNode root;

        class TrieNode {
            Map<Character, TrieNode> children;
            int prefixCounter;
            boolean isCompleteWord; //Not used here but keeping it anyway...

            TrieNode(){
                prefixCounter = 0;
                children = new HashMap<>();
                isCompleteWord = false;
            }

            TrieNode addAndIncrement(char c){
                if(children.get(c) == null){
                    children.put(c, new TrieNode());
                }
                TrieNode child = children.get(c);
                child.prefixCounter += 1;
                return child;
            }

            TrieNode findChild(char c){
                return children.get(c);
            }
        }

        Trie(){
            root = new TrieNode();
        }

        public void addWord(String word){
            if(findNumWordsForPrefix(word) > 0){
                return; //so we wont update the prefixCounter more than needed.
            }

            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++){
                cur = cur.addAndIncrement(word.charAt(i));
            }
            cur.isCompleteWord = true;
        }

        public int findNumWordsForPrefix(String prefix){
            TrieNode cur = root;
            for(int i = 0; i < prefix.length(); i++){
                cur = cur.findChild(prefix.charAt(i));
                if(cur == null) {
                    return 0;
                }
            }
            return cur.prefixCounter;
        }
    }
}