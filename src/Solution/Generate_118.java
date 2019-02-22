package Solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * Example:
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * @author BorisMirage
 * Time: 2019/01/09 19:32
 * Created with IntelliJ IDEA
 */

public class Generate_118 {
    /**
     * i,j  = i-1, j-1 + i-1, j
     *
     * @param numRows number of total rows
     * @return Pascal's triangle in linked list
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new LinkedList<>();


        if (numRows == 0) {
            return res;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new LinkedList<>();
            for (int j = 0; j <= i - 1; j++) {
                if (j == 0) {
                    temp.add(1);
                } else {
                    temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            temp.add(1);
            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {
        Generate_118 gen = new Generate_118();
        System.out.println(gen.generate(4));
    }
}

