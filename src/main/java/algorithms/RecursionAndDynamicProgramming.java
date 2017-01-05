package algorithms;

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

}
