package solutions;

import model.tree.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yael on 05/01/17.
 */
public class TreeAndGraphsSolutionsTest {

    @Test
    public void testBinaryTreePrinting(){
        BinaryTreeNode<Integer> root = getBinaryTreeTest();
        System.out.println(root.toString());
    }

    private BinaryTreeNode<Integer> getBinaryTreeTest(){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> leftRight = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> rightLeft = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> rightRight = new BinaryTreeNode<>(10);

        root.left = left;
        root.left.right = leftRight;

        root.right = right;
        root.right.left = rightLeft;
        root.right.right = rightRight;

        return root;
    }

    private BinaryTreeNode<Integer> getBinaryTreeTest2(){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> leftRight = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> leftLeft = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> rightLeft = new BinaryTreeNode<>(7);

        root.left = left;
        root.left.right = leftRight;
        root.left.left = leftLeft;

        root.right = right;
        root.right.left = rightLeft;

        return root;
    }

    @Test
    public void testGenerateBinarySearchTreeMinHeight(){

        Integer[] arr = new Integer[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 5;
        arr[3] = 6;
        arr[4] = 7;

        BinaryTreeNode<Integer> root = TreesAndGraphsSolutions.generateBinarySearchTreeMinHeight(arr);
        BinaryTreeNode<Integer> expectedTree = getBinaryTreeTest();
        System.out.println(root.toString());
        Assert.assertEquals(root.toString(), expectedTree.toString());

    }

    @Test
    public void testGenerateBinarySearchTreeMinHeight2(){

        Integer[] arr = new Integer[6];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 5;
        arr[3] = 6;
        arr[4] = 7;
        arr[5] = 10;

        BinaryTreeNode<Integer> root = TreesAndGraphsSolutions.generateBinarySearchTreeMinHeight(arr);
        BinaryTreeNode<Integer> expectedTree = getBinaryTreeTest2();
        System.out.println(root.toString());
        Assert.assertEquals(root.toString(), expectedTree.toString());

    }
}
