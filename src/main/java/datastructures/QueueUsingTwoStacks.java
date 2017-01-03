package datastructures;

import org.junit.Assert;

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
        if(!removingStack.empty()) {
            transferElementFromS1ToS2(removingStack, addingStack);
        }
        addingStack.push(element);
    }

    public T remove() {
        if(!addingStack.empty()){
            transferElementFromS1ToS2(addingStack, removingStack);
        }
        return removingStack.pop();
    }

    public T poll(){
        if(!addingStack.empty()){
            transferElementFromS1ToS2(addingStack, removingStack);
        }
        return removingStack.peek();
    }

    private static <T> void transferElementFromS1ToS2(Stack<T> s1, Stack<T> s2) {
        Assert.assertTrue(s2.empty());

        while(!s1.empty()){
            s2.push(s1.pop());
        }
    }
}