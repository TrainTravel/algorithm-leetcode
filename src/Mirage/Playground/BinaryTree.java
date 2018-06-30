package Mirage.Playground;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 2/25/18
 * Time: 14:35
 */

public class BinaryTree {
    /**
     * Binary Tree:
     * Elementsz1
     * 1. Node
     * 2. Relationship (parent, child)
     * 3. Orientation (left, right)
     * Operation
     * 1. Add child
     * 2. Traversal
     * 3. Return if exist
     */

    private int[] operateArray;

    public BinaryTree(int[] array) {
        operateArray = array;
    }

    public ArrayList<Integer> ConstructTree(){
        ArrayList<Integer> result = new ArrayList<Integer>(operateArray.length);
        return result;
    }

    /* Unit test */
    public static void main(String[] args) {

    }
}
