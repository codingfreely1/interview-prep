package model;

/**
 * Created by yael on 14/02/17.
 */
public class DoubleLinkedNode<T> {
    public T data;
    public DoubleLinkedNode left;
    public DoubleLinkedNode right;

    public DoubleLinkedNode(T data, DoubleLinkedNode left, DoubleLinkedNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
