package datastructures;

import java.util.Stack;

/**
 * Question 3.4 page 99
 * Created by yael on 03/01/17.
 */
public class QueueUsingTwoStacks<T> {

    private Stack<T> addingStack;
    private Stack<T> removingStack;

    public QueueUsingTwoStacks(){
        addingStack = new Stack<>();
        removingStack= new Stack<>();
    }

    public void add(T element){
        addingStack.push(element);
    }

    public int size(){
        return addingStack.size() + removingStack.size();
    }

    public T remove() {
        transferElementToBeRemovedIfNeeded();
        return removingStack.pop();
    }

    public T poll(){
        transferElementToBeRemovedIfNeeded();
        return removingStack.peek();
    }

    private void transferElementToBeRemovedIfNeeded() {
        if(removingStack.empty()){ //if not empty do not push to keep the order right.
            while(!addingStack.empty()){
                removingStack.push(addingStack.pop());
            }
        }

    }
}