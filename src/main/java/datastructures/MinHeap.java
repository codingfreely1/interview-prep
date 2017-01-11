package datastructures;

import util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yael on 11/01/17.
 */
public class MinHeap<T extends Comparable<T>> {

    private static final int NOT_FOUND = -1;
    private List<T> arr;

    public MinHeap() {
        this.arr = new ArrayList<>();
    }

    public T peek() {
        return arr.get(0);
    }

    public void add(T element){
        arr.add(element);
        bubbleUp(arr.size()-1);
    }

    public T removeMin(){
        if(arr.isEmpty()){
            return null;
        }

        T root = arr.get(0);

        if(arr.size() == 1) {
            arr.remove(0);
            return root;
        }

        T last = arr.remove(arr.size()-1) ;
        arr.set(0, last);
        bubbleDown(0);

        return root;
    }

    public int size(){
        return arr.size();
    }

    private void bubbleDown(int index){
        int leftChildInx = getLeftChildInx(index);
        int rightChildInx = getRightInx(index);

        while(leftChildInx != NOT_FOUND) { // there cannot be right child inx without left child.
            T left = arr.get(leftChildInx);
            T right = rightChildInx != NOT_FOUND ? arr.get(rightChildInx) : null;

            int minInxForSwap = right != null ? (right.compareTo(left) < 0 ? rightChildInx : leftChildInx) : leftChildInx;

            boolean swapWithChildRequired = arr.get(index).compareTo(arr.get(minInxForSwap)) > 0;
            if(swapWithChildRequired) {
                swap(index, minInxForSwap);
                index = minInxForSwap;
                leftChildInx = getLeftChildInx(index);
                rightChildInx = getRightInx(index);
            } else {
                break;
            }
        }
    }

    private void bubbleUp(int index) {
        int parentIndex = getParentInx(index);
        while(parentIndex >= 0){
            if(arr.get(index).compareTo(arr.get(parentIndex)) < 0 ) { //index smaller then parent
                swap(index, parentIndex);
                index = parentIndex;
                parentIndex = getParentInx(index);
            } else{
                break;
            }
        }
    }

    private int getLeftChildInx(int parentInx) {
        int leftChildInx = (parentInx * 2) + 1;
        return leftChildInx < arr.size() ? leftChildInx : NOT_FOUND;
    }


    private int getRightInx(int parentInx) {
        int rightChildInx = (parentInx * 2) + 2;
        return rightChildInx < arr.size() ? rightChildInx : NOT_FOUND;
    }

    private int getParentInx(int index) {
        if(index == 0 ) {
            return NOT_FOUND;
        }
        return (index -1) / 2;
    }

    private void swap(int inx1, int inx2){
        T temp = arr.get(inx1);
        arr.set(inx1, arr.get(inx2));
        arr.set(inx2, temp);
    }

    @Override
    public String toString() {
        return "[" + Utils.listWithCommaSeparator(arr) + "]";
    }
}
