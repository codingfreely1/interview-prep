package model.tree;

/**
 * Created by yael on 05/01/17.
 */
public class BinaryTreeNode<T> {
    private T data;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode<T> left;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" + data +
                ", \"right\": " + (right == null ? "null" : right.toString()) +
                ", \"left\": " + (left == null ? "null" : left.toString()) +
                "}";
    }
}
