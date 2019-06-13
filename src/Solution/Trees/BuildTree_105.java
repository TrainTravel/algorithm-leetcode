package Solution.Trees;

import Lib.Tree.TreeNode;

import java.util.HashMap;

/**
 * @author BorisMirage
 * Time: 2019/06/10 14:56
 * Created with IntelliJ IDEA
 */

public class BuildTree_105 {
    /**
     * preorder[0] is the root node.
     * Since array does not contain duplicated value, root node can be found in inorder[].
     * The left part of array in inorder[] is the left child of root, right part is right child.
     * Then preorder[1] is the left child's root, preorder[2] is the right child's root.
     * Repeat this process and finally this tree can be rebuilt.
     *
     * @param preorder pre order traversal array
     * @param inorder  in order traversal array
     * @return constructed tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        /* Corner case */
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        /* Use a hash map to store node value and node index for quicker searching */
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }


        return traverse(preorder, 0, preorder.length - 1, 0, inorder.length - 1, m);
    }

    /**
     * Find root of children in inorder array and in this way to find their left and right children.
     *
     * @param preorder pre order traversal array
     * @param preStart root in preorder traverse array
     * @param preEnd   end of tree in preorder array
     * @param inStart  start of left children
     * @param inEnd    end of right children
     * @param m        hash map for quickly find root index in inorder array
     * @return root node of current tree
     */
    private TreeNode traverse(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> m) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;        // end point
        }

        TreeNode root = new TreeNode(preorder[preStart]);       // first element in preorder array is root of current tree
        int inRoot = m.get(preorder[preStart]);     // find index of root in inorder array
        int leftChild = inRoot - inStart;       // left part of root in inorder array is left child of current root node

        root.left = traverse(preorder, preStart + 1, preStart + leftChild, inStart, inRoot - 1, m);
        root.right = traverse(preorder, preStart + leftChild + 1, preEnd, inRoot + 1, inEnd, m);
        return root;
    }
}
