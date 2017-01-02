package datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yael on 02/01/17.
 */
public class  MyQueue<T> {
    private List<T> list;

    public MyQueue(){
        list = new ArrayList<>();
    }

    public void add(T element){
        list.add(element);
    }

    public T remove(){
        if(list.size() > 0){
            return list.remove(0);
        }
        return null;
    }

    public T poll(){
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}