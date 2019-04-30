package Solution.Tree;

import Lib.Node;

import java.util.LinkedList;

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
     * Use queue to store each node in current and next layer.
     *
     * @param root root node
     * @return populate tree
     */
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        LinkedList<Node> layer = new LinkedList<>();
        layer.add(root);

        while (!layer.isEmpty()) {
            int s = layer.size();
            for (int i = 0; i < s; i++) {
                Node next = layer.pop();
                if (next.left != null) {
                    layer.add(next.left);
                }
                if (next.right != null) {
                    layer.add(next.right);
                }

                /* last node is initially set to null */
                if (i < s - 1) {
                    next.next = layer.peek();
                }
            }

        }
        return root;
    }
}
