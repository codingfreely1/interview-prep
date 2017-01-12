package algorithms;

import algorithms.model.Position;
import util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    static List<List<Position>> placeQueens (int n){
        List<List<Position>> results = new ArrayList<>();
        List<Position> curPositions = new ArrayList<>();
        placeQueens(n, curPositions, n-1, results);
        return results;
    }

    private static void  placeQueens (int n, List<Position> curPositions, int curRow, List<List<Position>> results) {
        if(curPositions.size() == n) {
            results.add(new ArrayList<>(curPositions));
            return;
        }

        boolean validPos;
        for (int col = 0 ; col < n ; col++){
            validPos = true;
            for(Position p : curPositions) {
                if(sameCol(col, p) || sameDiagonal(curRow, col, p)){
                    validPos = false;
                    break;
                }
            }

            if(validPos) {
                curPositions.add(new Position(curRow, col));
                placeQueens(n, curPositions, curRow -1, results);
                curPositions.remove(curPositions.size()-1);
            }
        }
    }

    private static boolean sameCol(int col, Position p){
        return p.getCol() == col;
    }

    private static boolean sameDiagonal(int row, int col, Position p){
        return (Math.abs(p.getRow() - row) == 1) && ( Math.abs(p.getCol() - col) == 1);
    }
}
