package Olivia;

import Mirage.LeetCodeSolution.Insert;
import sun.awt.SunHints;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation60 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] factorial = new int[n+1];
        int sum = 1;
        factorial[0] = 1;
        /* get the factorial number 1 1 2 6 24......n! */
        for(int i=1;i<=n;i++){
            sum *= (i);
            factorial[i] = sum;
        }
        /* get the number of numbers 1 2 3 4 */
        List<Integer> number = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            number.add(i);
        }
        k--;
        /* get each number */
        for(int i=1;i<=n;i++){
            int tmp = k/factorial[n-i];
            sb.append(String.valueOf(number.get(tmp)));
            number.remove(tmp);
            k = k - tmp*factorial[n-i];
        }
        return String.valueOf(sb);

    }
}
