package Lib;

/**
 * @author BorisMirage
 * Time: 2019/10/24 20:02
 * Created with IntelliJ IDEA
 */

public class GuessGame {
    private int target;

    public GuessGame(int n) {
        this.target = n;
    }

    public int guess(int n) {
        return Integer.compare(target, n);
    }
}
