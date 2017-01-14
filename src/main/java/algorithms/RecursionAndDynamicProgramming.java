package algorithms;

import algorithms.model.Position;
import util.Utils;

import java.util.*;

/**
 * Created by yael on 05/01/17.
 */
public class RecursionAndDynamicProgramming {

    public static <T extends Comparable<T>> void towersOfHanoi(Stack<T> source, Stack<T> middle, Stack<T> dest){

        moveIfLegal(source, middle);
        moveIfLegal(source, dest);
        moveIfLegal(middle,dest);

        if(source.empty() && middle.empty()){
            return;
        }

        if(moveIfLegal(source, middle)){
            towersOfHanoi(dest, middle, source);
            moveIfLegal(middle, dest);
            towersOfHanoi(source, middle, dest);
        }
    }

    public static <T extends Comparable<T>> boolean moveIfLegal(Stack<T> source, Stack<T> dest) {
        if(source.empty() || ( (!dest.empty()) && (source.peek().compareTo(dest.peek()) > 0) ) ){
            return false;
        }
        dest.push(source.pop());
        return true;
    }

    /**
     * 8.2 page 135
     * @param path
     * @param curPosition
     * @param dest
     * @param gridBorders
     * @return
     */
    static boolean findPath(List<Position.Direction> path, Position curPosition, Position dest,
                            Position gridBorders) {

        if(curPosition.equals(dest)) {
            return true;
        }

        int row = curPosition.getRow();
        int col = curPosition.getCol();

        for (Position.Direction d : Position.Direction.values()) {
            curPosition.move(d);
            if( isValidMove(curPosition, gridBorders)) {
                path.add(d);
                if( findPath(path, curPosition , dest, gridBorders)){
                    return true;
                }
                path.remove(path.size()-1);
            }
            curPosition.setPosition(row, col);
        }

        return false;
    }

    private static boolean isValidMove(Position curPosition, Position gridBorders) {

            if(curPosition.getCol() < 0 || curPosition.getCol() >= gridBorders.getCol()){
                return false;
            }
            if(curPosition.getRow() < 0 || curPosition.getRow() >= gridBorders.getRow()){
                return false;
            }
            return true;
    }

    /**
     * q 8.3 page 135
     * O(logN) running time.
     * @param arr
     * @param start
     * @param end in bounds index
     * @return
     */
    static int searchMagicIndex (int[] arr, int start, int end) {

        if(start > end ){
            return -1;
        }

        int midInx = (start + end)/2;
        int value = arr[midInx];
        if( midInx > value ) {
            return searchMagicIndex(arr, midInx+1, end) ;
        } else if( midInx < value ) {
            return searchMagicIndex(arr, start,midInx-1) ;
        } else {
            return midInx;
        }
    }

    /**
     *
     * @param list
     * @param n - number of pairs.
     * @param open
     * @param close
     */
    static void printLegalParens(List<Character> list, int n, int open, int close) {

        if(open + close == 2*n){
            System.out.println(Utils.listWithSeparator(list, ""));
        }

        if(open > close){
            list.add(')');
            printLegalParens(list, n, open, close + 1);
            list.remove(list.size()-1);
        }

        if(open < n) {
            list.add('(');
            printLegalParens(list, n, open + 1, close);
            list.remove(list.size()-1);
        }
    }

    /**
     * q 8.12
     * @param n
     * @return
     */
    static List<Integer[]> placeQueens (int n){
        List<Integer[]> results = new ArrayList<>();
        Integer[] columnsPerRow = new Integer[n];
        placeQueens(n, columnsPerRow, 0, results);
        return results;
    }

    /**
     *
     * @param n
     * @param columnsPerRow array storing the previous positions. each index is the row and the value is the matching columns. arr[row] = col
     * @param curRow
     * @param results
     */
    private static void  placeQueens (int n, Integer[] columnsPerRow, int curRow, List<Integer[]> results) {
        if(curRow == n) {
            results.add(columnsPerRow.clone());
            return;
        }

        for (int col = 0 ; col < n ; col++){
            if(isValidPos(columnsPerRow, curRow, col)) {
                columnsPerRow[curRow] = col;
                placeQueens(n, columnsPerRow, curRow +1, results);
                columnsPerRow[curRow] = -1;
            }
        }
    }

    private static boolean isValidPos(Integer[] columnsPerRow, int curRow, int curCol) {
        int row = 0;
        while(row < curRow) {
            if (curCol == columnsPerRow[row] || sameDiagonal(curRow, curCol, row, columnsPerRow[row])) {
                return false;
            }
            row++;
        }
        return true;
    }

    private static boolean sameDiagonal(int row1, int col1, int row2, int col2){
        return (Math.abs(row2 - row1) == Math.abs(col2 - col1));
    }

    /**
     * q 8.14 Boolean Evaluation
     * @param expression
     * @param val
     * @return
     */
    static int evaluate(String expression, boolean val) {
        recursionLevel++;
        String key = expression + String.valueOf(val);
        if(useOptimization) {
            if(calculatedValues.get(key) != null){
                return calculatedValues.get(key);
            }
        }

        if (expression.isEmpty()) {
            return 1;
        }

        if (expression.equals("0")) {
            return val ? 0 : 1;
        }

        if (expression.equals("1")) {
            return val ? 1 : 0;
        }

        int numWays = 0;
        for (int i = 0; i < expression.length(); i++) {
            char op = expression.charAt(i);
            if(op == '&' || op == '|' || op == '^') {
                String leftSide = expression.substring(0, i);
                String rightSide = "";

                if(i+1 < expression.length()){
                    rightSide = expression.substring(i+1, expression.length()); //split[1];
                }
                if (op == '&') {
                    numWays += getNumForAnd(leftSide, rightSide, val);
                } else if (op == '|') {
                    numWays += getNumForOr(leftSide, rightSide, val);
                } else {// (op == '^') {
                    numWays += getNumForXor(leftSide, rightSide, val);
                }
            }
        }
        if(useOptimization){
            calculatedValues.put(key, numWays);
        }
        return numWays;
    }

    public static boolean useOptimization = true;
    public static int recursionLevel = 0;
    private static Map<String, Integer> calculatedValues = new HashMap<>();

    static int getNumForOr(String left,String right, boolean val){
        int numWays = 0;
        if(val){
            numWays += getFinalNumber(left, right, val, !val);
            numWays += getFinalNumber(left, right, !val, val);
        }
        numWays += getFinalNumber(left, right, val, val);
        return numWays;
    }

    static int getNumForAnd(String left,String right, boolean val){
        int numWays = 0;
        if(!val){
            numWays += getFinalNumber(left, right, val, !val);
            numWays += getFinalNumber(left, right, !val, val);
        }
        numWays += getFinalNumber(left, right, val, val);
        return numWays;
    }

    static int getNumForXor(String left,String right, boolean val){
        int numWays = 0;
        if(val){
            numWays += getFinalNumber(left, right, val, !val);
            numWays += getFinalNumber(left, right, !val, val);
        } else {
            numWays += getFinalNumber(left, right, val, val);
            numWays += getFinalNumber(left, right, !val, !val);
        }
        return numWays;
    }

    static int getFinalNumber(String leftSide,String rightSide,  boolean rightVal, boolean leftVal){
        int numLeft= evaluate(leftSide, leftVal);
        int numRight = evaluate(rightSide, rightVal);

        if(numLeft > 0 && numRight > 0){
            return numLeft * numRight;
        }
        return 0;
    }

    /**
     * q 8.4 Power Set - Solution 1
     * @param set
     * @return
     */
    static List<List<Integer>> findAllSubset(Integer[] set){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        findAllSubsetHelper(set, 0, list, cur);
        return list;
    }

    private static void findAllSubsetHelper(Integer[] set, int curIndex, List<List<Integer>> list, List<Integer> cur){
        if(curIndex >= set.length){
            list.add(new ArrayList<>(cur));
            return;
        }

        cur.add(set[curIndex]);
        findAllSubsetHelper(set, curIndex + 1, list, cur);
        cur.remove(cur.size()-1);
        findAllSubsetHelper(set, curIndex + 1, list, cur);
    }

    /**
     * q 8.4 Power Set - Solution 2
     * @param set
     * @return
     */
    static List<List<Integer>> findAllSubsetIteratively(Integer[] set){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        int n = set.length;
        int numberOfSubset = (int) Math.pow(2, n);
        int i = 0;
        while (i < numberOfSubset){
            for (int j = 0; j < n; j++) {
                if(isBitSetInIndex(j, i)){
                    cur.add(set[j]);
                }
            }
            list.add(cur);
            cur = new ArrayList<>();
            i++;
        }

        return list;
    }

    public static boolean isBitSetInIndex(int index, int number){
        int mask = 1 << index; // equivalent to Math.pow(2,index)
        int res = number & mask;
        return res > 0;
    }

    /**
     * q 8.4 Power Set - Solution 2.5
     * @param set
     * @return
     */
    static List<List<Integer>> findAllSubsetIteratively2(Integer[] set){
        List<List<Integer>> list = new ArrayList<>();

        int n = set.length;
        int numberOfSubset = 1 << n;//equivalent to Math.pow(2, n);
        int i = 0;
        while (i < numberOfSubset){
            list.add(getSetFromNumber(i, set));
            i++;
        }

        return list;
    }

    private static List<Integer> getSetFromNumber(int number, Integer[] set){
        List<Integer> cur = new ArrayList<>();
        int index = 0;

        for (int j = number; j > 0 ; j = j>>1 ) { //shift j by one each iteration - equivalent to dividing j by 2 in each iteration.
            if( (j & 1) == 1 ){ //if the bit in 0 is 1.
                cur.add(set[index]);
            }
            index++;
        }
        return cur;
    }
    /**
     * q 8.4 Power Set - Solution 3
     * @param set
     * @return
     */
    static List<List<Integer>> findAllSubsetSolution3(Integer[] set){
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>()); // adding empty set for base case

        for (int i = 0; i < set.length; i++) {
            List<List<Integer>> cloned = new ArrayList<>(allSubsets);
            int currentVal = set[i];
            for(List<Integer> subset : cloned){
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(currentVal);
                allSubsets.add(newSubset);
            }
        }
        return allSubsets;
    }
}
