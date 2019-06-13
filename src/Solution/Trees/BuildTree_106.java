package Solution.Trees;

import Lib.Tree.TreeNode;

import java.util.HashMap;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * @author BorisMirage
 * Time: 2019/06/10 18:02
 * Created with IntelliJ IDEA
 */

public class BuildTree_106 {

    /**
     * The last element of postorder is always the root of tree.
     *
     * @param inorder   inorder array
     * @param postorder postorder array
     * @return rebuild binary tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        /* Corner case */
        if (postorder.length == 0) {
            return null;
        }
        if (postorder.length == 1) {
            return new TreeNode(postorder[0]);
        }

        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        return rebuild(postorder, postorder.length - 1, 0, 0, inorder.length - 1, m);
    }

    /**
     * Find the root in postorder and then use the inorder array to find child's length and continue.
     * For better understanding, pStart is the last element in postorder, therefore pStart > pEnd.
     *
     * @param postorder postorder array
     * @param pStart    postorder start position in current recursion (pStart > pEnd)
     * @param pEnd      postorder end position in current recursion (pStart > pEnd)
     * @param inStart   inorder start position in current recursion
     * @param inEnd     inorder end position in current recursion
     * @param m         hash map
     * @return root node of current tree
     */
    private TreeNode rebuild(int[] postorder, int pStart, int pEnd, int inStart, int inEnd, HashMap<Integer, Integer> m) {

        /* End point */
        if (inStart > inEnd || pEnd > pStart) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pStart]);
        int inRoot = m.get(postorder[pStart]);
        int leftChild = inRoot - inStart;

        root.right = rebuild(postorder, pStart - 1, pEnd + inRoot - inStart, inRoot + 1, inEnd, m);
        root.left = rebuild(postorder, pEnd + leftChild - 1, pEnd, inStart, inRoot - 1, m);

        return root;
    }
}
