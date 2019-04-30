package Solution.Tree;

import Lib.Node;


/**
 * Given a binary tree (not perfect).
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 * @author BorisMirage
 * Time: 2019/04/30 09:53
 * Created with IntelliJ IDEA
 */

public class Connect_117 {
    /**
     * Use a Node to store previous node, link to next node.
     * Use a Node to store the next layer's head node for iteration.
     *
     * @param root root node
     * @return populate tree
     */
    public Node connect(Node root) {
        Node nextHead = null;
        Node nextPrevious = null;
        Node current = root;

        /* Iterate whole tree */
        while (current != null) {

            /* Iterate current layer */
            while (current != null) {

                /* Left child */
                if (current.left != null) {
                    if (nextPrevious != null) {
                        nextPrevious.next = current.left;
                    } else {
                        nextHead = current.left;        // find new layer
                    }
                    nextPrevious = current.left;
                }

                /* Right child */
                if (current.right != null) {
                    if (nextPrevious != null) {
                        nextPrevious.next = current.right;
                    } else {
                        nextHead = current.right;       // find new layer
                    }
                    nextPrevious = current.right;
                }
                current = current.next;
            }
            current = nextHead;     // going to next layer
            nextHead = null;
            nextPrevious = null;
        }
        return root;
    }
}
