package Solution.Tree;

import Lib.Node;

import java.util.LinkedList;

/**
 * @author BorisMirage
 * Time: 2019/04/30 09:53
 * Created with IntelliJ IDEA
 */

public class Connect_117 {
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
                if (i < s - 1) {
                    next.next = layer.peek();
                }
            }

        }
        return root;
    }
}
