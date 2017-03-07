package solutions;

import org.junit.Assert;
import model.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yael on 11/01/17.
 */
public class InterviewQuestionsSolutions {

    //mh interview questions.
    /**
     * return formatted century String for given year.
     * Examples were given : input (2000) output (20th) ,  input (2012) output (21st)
     * @param yearStr
     * @return
     */
    public static String getFormattedCenturyString(String yearStr) {
        int year = Integer.valueOf(yearStr);
        int divider = (int) Math.pow(10,2);
        int century = year / divider;
        if(year % divider > 0){
            century +=1;
        }
        return String.valueOf(century) + getSuffixPerDigit(century%10); //I forgot the modulo in the actual interview.

    }

    private static Map<Integer,String> suffixPerDigit = new HashMap<>();
    static {
        suffixPerDigit.put(0,"th");
        suffixPerDigit.put(1,"st");
        suffixPerDigit.put(2,"nd");
        suffixPerDigit.put(3,"rd");
        suffixPerDigit.put(4,"th");
        suffixPerDigit.put(5,"th");
        suffixPerDigit.put(6,"th");
        suffixPerDigit.put(7,"th");
        suffixPerDigit.put(8,"th");
        suffixPerDigit.put(9,"th");
    }

    private static String getSuffixPerDigit(int digit){
        return suffixPerDigit.get(digit);
    }

    /**
     * The function should return lower case string with _ separator.
     * Examples: Test7Boo -> test7_boo, 1 -> 1 , SubString -> sub_string
     * @param str
     * @return
     */
    public static String toLowerCaseWithUnderscoreDelimiter(String str){
        //String[] subStrings = str.split("[A-Z]"); // the split removes the separator chars.
        String[] subStrings = str.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");//didn't get this regex in the interview obviously..
        StringBuilder sb = new StringBuilder();
        for(String s: subStrings){
            sb.append(s.toLowerCase()).append("_");
        }
        sb.replace(sb.length() -1, sb.length(), ""); //to remove the last "_";
        return sb.toString();
    }

    /**
     * The function should returns true if it finds a subset of the array the its sum equals the given sum.
     * Examples were given: [2, 9, 4, 7] sum = 15 should return true cause 2+9+4 = 15
     * @param arr
     * @param sum
     * @return
     */
    public static boolean isSubsetEqualsToSumExist(int[] arr, int sum){
        Assert.assertTrue(sum > 0);
        return subsetEqualsSumHelper(arr, sum, 0, 0); //I might have forgotten to write 'return' :/
    }

    public static boolean subsetEqualsSumHelper(int[] arr, int sum, int curSum, int curInx) {
        if(sum == curSum){
            return true;
        }

        if(curInx >= arr.length) {
            return false;
        }

        boolean isSubsetFound = subsetEqualsSumHelper(arr, sum, curSum + arr[curInx], curInx + 1);
        if(!isSubsetFound){
                isSubsetFound = subsetEqualsSumHelper(arr, sum, curSum, curInx + 1);//I might have forgotten the assignment and just called the function :/
        }
        return isSubsetFound;
    }
    //mh interview questions. - end

    //google interview question from youtube
    static Pair<Integer, Integer> findPairMatchSumInOrderedArray(int[] arr, int sum) {
        int startInx = 0 ;
        int endInx = arr.length -1;

        while(startInx < endInx) {

            if(arr[startInx] > sum) { //since the array is sorted in ascending order if first is larger than sum we wont be able to find a match.
                System.out.println("in" + startInx + ", " + endInx);
                return null;
            }

            int curSum = arr[startInx] + arr[endInx];
            if(curSum == sum) {
                return new Pair<>(startInx, endInx);
            } else if(curSum < sum) {
                startInx++;
            } else {
                endInx--;
            }
        }
        return null;
    }

    static Pair<Integer, Integer> findPairMatchSumInUnsortedArray(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< arr.length ; i++){
            int curVal = arr[i];
            Integer index = map.get(curVal);
            if(index != null){
                return new Pair<>(index, i);
            }
            map.put(sum-curVal, i);
        }
        return null;
    }

    //workshop
    public static class Interval implements Comparable<Interval>{
        int start;
        int end;
        Interval(int start, int end){
            this.start = start;
            this. end= end;
        }

        @Override
        public int compareTo(Interval other){
            return this.start - other.start;
        }
    }

    public static boolean isAllFile(List<Interval> intervalArray, int fileSize) {
        Collections.sort(intervalArray);
        Integer min = null;
        Integer max = null;
        for(Interval i: intervalArray){
            if(min == null){
                if( i.start != 0){
                    return false;
                }
                min = i.start;
                max = i.end;
            } else if(i.start >= min && i.start <= max+1) {
                max = (i.end > max) ? i.end : max;
            }
        }
        return max != null && max == (fileSize-1);
    }

/*
 000010
 110010
 010001
 000010
 */

/*
 * 00010
 * 11010
 * 10100
 * 11100
 * 00000
 */

//    public static int getMaxIsland(int[][] matrix) {
//
//        visited = new boolean[matrix.length][matrix[0].length];
//        int max = 0;
//        for(int i = 0; i < matrix.length ; i++){
//            for(int j = 0; j < matrix[0].length ; j++){
//                int cur = countOnes(matrix, i, j);
//                if(cur > max) {
//                    max = cur;
//                }
//            }
//        }
//        return max;
//    }
//
//    private static boolean[][] visited;
//
//
//    private static int countOnes(int[][] matrix, int r, int c){
//
//        if(!inBounds(matrix, r, c) || matrix[r][c] == 0 || visited[r][c]) {
//            return 0;
//        }
//
//        visited[r][c] = true;
//
//        return  matrix[r][c] + countOnes(matrix, r-1, c)
//                + countOnes(matrix, r+1, c)
//                + countOnes(matrix, r, c-1)
//                + countOnes(matrix, r, c+1);
//    }
//
//    private static boolean inBounds(int[][] matrix, int row, int col) {
//        if(row < matrix.length && row >= 0 && col < matrix[0].length && col >= 0 ){
//            return true;
//        }
//        return false;
//    }

//import java.io.*;
//import java.util.*;


//    class Solution {
//        private static List<String> getAllUrls(String url) {
//            Queue<String> queue = new LinkedList<>();
//            Set<String> visited = new HashSet<>();
//
//            queue.add(url);
//
//            while(!queue.isEmpty()) {
//
//                String cur = queue.remove();
//                if(!visited.contains(cur)){
//                    visited.add(cur);
//                    queue.addAll(getLinks(url));
//                }
//
//            }
//
//            return visited;
//        }
//
//        private static List<String> getLinks(String url){
//
//        }
//
//        private static ExecuterService pool;
//        private static Queue<String> queue = new LinkedList<>();
//        private static Set<String> visited = new HashSet<>();
//        private static int runningTasks = 0;
//        private static Lock lock = new ReentrantLock();
//
//        private static List<String> getAllUrls(String url) {
//
//
//            queue.add(url);
//
//            pool = Executer.newFixedThreadPool(MAX_THREADS);
//
//            Runnable task = new Runnable(){
//                @Override
//                public void run(){
//                    lock.lock();
//                    String cur = queue.remove();
//                    if(!visited.contains(cur)){
//                        visited.add(cur);
//                        queue.addAll(getLinks(url));
//                    }
//                    runningTasks--;
//                    lock.release();
//                }
//            }
//
//
//            while(!queue.isEmpty() || runningTasks > 0 ) {
//
//                if(!queue.isEmpty()){
//                    runningTasks++;
//                    pool.submit(task);
//                }
//            }
//
//            return visited;
//        }
//
//    }
}
