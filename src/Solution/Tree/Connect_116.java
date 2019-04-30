package Solution.Tree;

import Lib.Node;

/**
 * A perfect binary tree is given where all leaves are on the same level, and every parent has two children.
 * The binary tree has the following definition:
 * Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 *
 * @author BorisMirage
 * Time: 2019/04/28 17:34
 * Created with IntelliJ IDEA
 */

public class Connect_116 {
    /**
     * It is a perfect binary tree. Hence, simply point next layer's sub node to its right node.
     * left sub node -> right sub node
     * right sub node -> next left sub node
     * If reach the end of current layer node, do nothing. The default next is null.
     *
     * @param root root node
     * @return populated tree
     */
    public Node connect(Node root) {
        Node level = root;
        while (level != null) {
            Node cur = level;
            while (cur != null) {

                /* Link left and right sub node under same parent node */
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }

                /* Link right sub node to next parent node's left sub node */
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;     // next node
            }
            level = level.left;     // next layer
        }
        return root;
    }
}
