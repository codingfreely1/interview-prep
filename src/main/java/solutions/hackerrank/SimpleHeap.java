package solutions.hackerrank;

import java.io.*;
import java.util.*;

/**
 * Created by yael on 17/01/17.
 * Solved hackerrank heap challenge. https://www.hackerrank.com/challenges/qheap1
 * This implementation of the heap is different than the previous one I've implemented because it supports removal
 * of elements from the entire heap, not just the root.
 */
public class SimpleHeap {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        MinHeap heap = new MinHeap();
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        for(int i = 0; i<n ; i++ ){
            String line = sc.nextLine();
            String[] s = line.split(" ");
            String command = s[0];
            if(command.equals("1")){
                heap.add(Integer.valueOf(s[1]));
            } else if(command.equals("2")){
                heap.remove(Integer.valueOf(s[1]));
            } else if(command.equals("3")){
                System.out.println(heap.getMin());
            }
        }
    }

    static class MinHeap {

        ArrayList<Integer> arr;

        MinHeap(){
            arr = new ArrayList<>();
        }

        void add(int val){
            arr.add(val);
            bubbleUpLast();
        }

        void bubbleUpLast(){
            int cur = arr.size()-1;
            int parent = getParent(cur);
            while(cur > 0){
                if(arr.get(cur) < arr.get(parent)){
                    swap(cur,parent);
                    cur = parent;
                    parent = getParent(cur);
                } else{
                    break;
                }
            }
        }

        void remove(int val){
            int inx = arr.indexOf(val);
            if(arr.isEmpty()){
                return;
            }
            int last = arr.get(arr.size()-1);
            arr.set(inx, last);
            bubbleDown(inx);
            arr.remove(arr.size()-1);
        }

        void bubbleDown(int inx){
            int cur = inx;
            int val = arr.get(cur);
            while(hasLeft(cur)){//cannot have right if does not have left
                int minInx = getLeft(cur);
                int rightInx = -1;
                if(hasRight(cur)){
                    rightInx = getRight(cur);
                }
                minInx = (rightInx != -1) ? (arr.get(minInx) < arr.get(rightInx) ? minInx : rightInx) : minInx;
                if(val > arr.get(minInx)){
                    swap(minInx, cur);
                    cur = minInx;
                } else {
                    break;
                }
            }
        }

        void swap(int inx1, int inx2){
            int temp = arr.get(inx1);
            arr.set(inx1, arr.get(inx2));
            arr.set(inx2, temp);
        }

        int getLeft(int index){
            return index*2 + 1;
        }

        int getParent(int index){
            return (index-1)/2;
        }

        int getRight(int index){
            return index*2 + 2;
        }

        boolean hasLeft(int index){
            return getLeft(index) < arr.size();
        }

        boolean hasRight(int index){
            return getRight(index) < arr.size();
        }

        int getMin(){
            if(arr.isEmpty()){
                return -1;//should not happen here.
            }
            return arr.get(0);
        }
    }
}