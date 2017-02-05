package algorithms;

import jdk.nashorn.internal.runtime.BitVector;

import java.util.*;

/**
 * Created by yael on 31/12/16.
 */
public class ArraysAndStrings {

    //Question 1.1 page 90
    //Determines if a string has all unique characters with and without using additional data structure.

    /**
     * Running time O(n^2). no additional space used.
     * @param s
     * @return
     */
    public static boolean isUnique(String s){
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            for (int j = 0; j < i; j++) {
                if(s.charAt(j) == curChar) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * running time O(n). constant space. assuming characters a-z for the lengths.
     * should be larger if to support other characters.
     * @param s
     * @return
     */
    public static boolean isUniqueUsingBitVector(String s){
        BitVector bv = new BitVector(26);
        for (int i = 0; i < s.length(); i++) {
            int charInx = getCharInx(s.charAt(i));
            if(bv.isSet(charInx)) {
                return false;
            } else {
                bv.set(charInx);
            }
        }
        return true;
    }

    /**
     * running time O(NlogN). O(N) space.
     * Assuming sort is O(NlogN) and is not using additional space
     * @param s
     * @return
     */
    public static boolean isUniqueUsingSort(String s){
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            characters.add(s.charAt(i));
        }

        characters.sort(Character::compareTo);

        int last = -1;
        for (int i = 0; i < characters.size(); i++) {
            int cur = getCharInx(characters.get(i));
            if( cur == last){
                return false;
            } else {
                last = cur;
            }
        }
        return true;
    }

    private static int getCharInx(char c){
        return c - 'a';
    }

    public static boolean isUniqueBookSolution(String s){
        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = getCharInx(s.charAt(i));
            if((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static int findLongestSubStringNoDups(String s) {
        if(s.isEmpty()){
            return 0;
        }
        Map<Character,Integer> chars = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length() ; i++){
            char curChar = s.charAt(i);
            Integer lastInx = chars.get(curChar);
            if(lastInx != null) {
                for(int j = start; j<= lastInx ; j++){
                    chars.remove(s.charAt(i) );
                }
                start = lastInx+1;
            }
            end++;
            if((end - start) > maxLen ) {
                maxLen = end - start;
            }
            chars.put(curChar, i);
        }
        return maxLen;
    }

}
