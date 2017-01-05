package solutions;

import model.tree.BinaryTreeNode;

/**
 * Created by yael on 05/01/17.
 */
public class TreesAndGraphsSolutions {

    /**
     * q 4.2 page 109 MinimalTree.
     * @param sortedArr
     * @param <T>
     * @return
     */
    public static <T> BinaryTreeNode<T> generateBinarySearchTreeMinHeight(T[] sortedArr) {
        int mid = sortedArr.length / 2;
        BinaryTreeNode<T> root = new BinaryTreeNode<>(sortedArr[mid]);
        generateLeftSide(sortedArr, root, mid) ;
        generateRightSide(sortedArr, root, mid) ;
        return root;
    }

    private static <T> void generateLeftSide(T[] sortedArr, BinaryTreeNode<T> curNode, int inx){
        //adding left child to node
        if(inx -2 >= 0) {
            curNode.left = new BinaryTreeNode<>(sortedArr[inx -2]);
            curNode.left.right = new BinaryTreeNode<>(sortedArr[inx -1]);
            generateLeftSide(sortedArr, curNode.left, inx -2);
        } else if(inx -1 >= 0){
            curNode.left = new BinaryTreeNode<>(sortedArr[inx -1]);
        }
    }
    private  static <T> void generateRightSide(T[] sortedArr, BinaryTreeNode<T> curNode, int inx) {
        //adding right child to node
        if(inx+2< sortedArr.length) {
            curNode.right = new BinaryTreeNode<>(sortedArr[inx +2]);
            curNode.right.left = new BinaryTreeNode<>(sortedArr[inx +1]);
            generateRightSide(sortedArr, curNode.right, inx + 2);
        } else if(inx +1 < sortedArr.length){
            curNode.right = new BinaryTreeNode<>(sortedArr[inx +1]);
        }
    }
}
