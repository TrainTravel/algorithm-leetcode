package Playground;


/**
 * @author BorisMirage
 * Created by borismirage on 2017/6/14.
 */

public class UnionFind {
    private int count;
    private int[] array;
    private int[] size;

    /**
     * Initializing Union find class.
     */

    public UnionFind(int N) {
        count = N; // N is the length of this array.
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i;
        }
        size = new int[N];
        for (int i = 0; i < count; i++) {
            size[i] = 1;
        }
    }

    /**
     * Class Quick find.
     */

    public class QuickFind {

        public boolean isQFConnected(int i, int j) {

            return array[i] == array[j];
        }

        public void setQFConntected(int child, int root) {
            if (child > count || root > count) {
                throw new ArrayIndexOutOfBoundsException("Index out of range.\n");
            }
            array[child] = array[root];
        }
    }

    /**
     * Class Quick union.
     */

    public class QuickUnion {

        private int returnRoot(int i) {
            while (array[i] != i) {
                i = array[i]; // This method chasing back to its root.
            }
            return i;
        }

        public void setQUConnected(int child, int root) {
            int childRoot = returnRoot(child);
            int rootRoot = returnRoot(root);
            array[childRoot] = rootRoot; // To replace child node's root node by import root's root.
        }

        public boolean isQUConnteced(int node1, int node2) {
            return returnRoot(node1) == returnRoot(node2);
        }
    }

    /**
     * Class Weighted Quick Union.
     */

    public class WeightedQuickUnion {
        private int returnWeighteRoot(int child) {
            while (array[child] != child) {
                array[child] = array[array[child]]; // Make every other node in path point to its grandparent node.
                child = array[child]; // This method chasing back to its root.
            }
            return child;
        }

        /**
         * Unit Test
         */

        public void setWeighteQUConnected(int child, int root) {
            int childRoot = returnWeighteRoot(child);
            int rootRoot = returnWeighteRoot(root);
            if (childRoot == rootRoot) {
                return;
            }
            if (size[childRoot] < size[rootRoot]) { // Checking tree's size, assure linking smaller tree to larger tree.
                array[childRoot] = rootRoot;
                size[childRoot] += size[rootRoot]; // To replace child node's root node value by import root's root value.
            } else {
                array[rootRoot] = childRoot;
                size[rootRoot] += size[childRoot]; // To replace child node's root node by import root's root.
            }
            array[childRoot] = rootRoot;
        }

        public boolean isWeighteQUConnteced(int node1, int node2) {
            return returnWeighteRoot(node1) == returnWeighteRoot(node2);
        }

    }
}
