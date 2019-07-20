package Solution.Stack;

import java.util.Stack;

/**
 * Given a string of comma separated values, verify if it is a correct preorder traversal serialization of binary tree.
 * Find an algorithm without reconstructing the tree.
 *
 * @author BorisMirage
 * Time: 2019/06/27 16:27
 * Created with IntelliJ IDEA
 */

public class IsValidSerialization_331 {
    /**
     * Using stack to store nodes including "#".
     * Case 1: number -> push it to the stack.
     * Case 2: # -> check if the top of stack is also #.
     * If so, pop until top of stack is not #.
     * Finally, check if stack size is 1, and stack top is #.
     *
     * @param preorder given preorder nodes
     * @return whether it is a correct preorder traversal serialization of a binary tree
     */
    public boolean isValidSerialization(String preorder) {

        /* Corner case */
        if (preorder.charAt(0) == '#' && preorder.length() > 1) {
            return false;
        }

        Stack<String> s = new Stack<>();
        String[] arr = preorder.split(",");

        for (int i = 0; i < arr.length; i++) {

            while (arr[i].equals("#") && !s.isEmpty() && s.peek().equals("#")) {
                s.pop();
                if (s.isEmpty()) {
                    return false;       // pop out root -> invalid tree
                }
                s.pop();
            }
            s.push(arr[i]);
        }
        System.out.println(s);
        return s.size() == 1 && s.peek().equals("#");
    }

    /**
     * All non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
     * All null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
     * Difference between out degree and in degree: outdegree - indegree
     * If the node is not null, increase diff by 2, because it provides two out degrees.
     * If a serialization is correct, outdegree - indegree should never be negative and diff will be zero when finished.
     *
     * @param preorder given preorder nodes
     * @return whether it is a correct preorder traversal serialization of a binary tree
     */
    public boolean degree(String preorder) {

        /* Corner case */
        if (preorder.charAt(0) == '#' && preorder.length() > 1) {
            return false;
        }

        String[] nodes = preorder.split(",");
        int diff = 1;       // root has
        for (String node : nodes) {
            if (--diff < 0) {
                return false;
            }
            if (!node.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}
