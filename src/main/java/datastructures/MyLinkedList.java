package datastructures;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by yael on 02/01/17.
 */
public class MyLinkedList<T extends Comparable<T>> {

    class Node<T extends Comparable> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> root;
    private Node<T> last;
    private int size = 0;

    public MyLinkedList() {}

    public void add(T data) {
        Node<T> newNode = this.new Node<>(data, null);
        if(this.root == null){
            this.root = newNode;
            this.last = this.root;
        } else {
            this.last.next = newNode;
            this.last  = newNode;
        }
        size++;
    }

    public T get(int i){
        if( i < 0 || i>= size) {return null;}

        Node<T> cur = this.root;
        int j = 0;
        while(cur != null) {
            if(j == i){
                return cur.data;
            }
            cur = cur.next;
            j++;
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    public void remove(int i){
        if( i < 0 || i>= size) {return;}

        if(i == 0){
            removeFirst();
            return;
        }

        Node<T> cur = this.root;
        int j = 0;
        while(cur != null) {
            if(j+1 == i){
                removeHelper(cur, cur.next);
                break;
            }
            cur = cur.next;
        }
    }

    public void removeFirst(){
        removeHelper(null, this.root);
    }

    private void removeHelper(Node<T> previous, Node<T> toRemove){

        if(previous == null){ //removing root.
            this.root = toRemove.next;
            if(toRemove.next == null){//size was 1 and both root and last will be null
                this.last = null;
            }
        } else {
            previous.next = toRemove.next;
            if(toRemove.next == null){//last was removed.
                this.last = previous;
            }

        }
        size--;
    }

    public void clear(){
        this.root = null;
        this.last = null;
        this.size = 0;
    }

    public void addAll(Collection<T> c){
        Iterator<T> i = c.iterator();
        while(i.hasNext()){
            add(i.next());
        }
    }

    public boolean contains(T data){
        return indexOf(data) != -1;
    }

    public int indexOf(T data) {
        Node<T> cur = this.root;
        int i = 0;
        while (cur != null) {
            if (cur.data.compareTo(data) == 0) {
                return i;
            }
            i++;
            cur = cur.next;
        }
        return -1;
    }
}