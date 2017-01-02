package datastructures;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yael on 02/01/17.
 */
public class MyStack<T> {
    private List<T> list;

    public MyStack(){
        list = new LinkedList<>();
    }

    public void push(T element){
        list.add(0,element);
    }

    public T pop(){
        if(list.size() > 0){
            return list.remove(0);
        }
        return null;
    }

    public T peek(){
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    public boolean empty(){
        return list.isEmpty();
    }
}