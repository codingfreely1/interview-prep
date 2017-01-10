package algorithms;

import algorithms.model.Position;

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



}
