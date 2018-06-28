package Olivia;

public class MaxArea11 {
    public int maxArea(int[] height) {
        int startLoc = 0;
        int endLoc = height.length - 1;
        int cur = (height.length - 1) * Math.min(height[0], height[height.length - 1]);
        while (startLoc < endLoc) {
            if (height[startLoc] < height[endLoc]) {
                if (height[startLoc + 1] > height[startLoc]) {
                    int now = (endLoc - startLoc - 1) * Math.min(height[startLoc + 1], height[endLoc]);
                    if (now > cur) {
                        cur = now;
                    }
                }
                startLoc++;
            } else {
                if (height[endLoc - 1] > height[endLoc]) {
                    int now = (endLoc - startLoc - 1) * Math.min(height[startLoc], height[endLoc - 1]);
                    if (now > cur) {
                        cur = now;
                    }
                }
                endLoc--;
            }
        }
        return cur;
    }
}
