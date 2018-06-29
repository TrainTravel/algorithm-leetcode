package Olivia;

public class IsPalindrome9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x <= 9) return true;
        int cur = 0;
        int tmp = x;
        while (tmp / 10 != 0 || tmp % 10 != 0) {
            int remain = tmp % 10;
            cur = cur * 10 + remain;
            tmp = tmp / 10;
        }
        if (cur == x) return true;
        else {
            return false;
        }

    }
}
