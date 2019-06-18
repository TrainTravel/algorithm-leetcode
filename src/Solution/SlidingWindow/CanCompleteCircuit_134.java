package Solution.SlidingWindow;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank.
 * It costs cost[i] of gas to travel from station i to its next station (i+1).
 * Begin the journey with an empty tank at one of the gas stations.
 * Return the starting station's index if it can travel around the circuit once in the clockwise direction.
 * Otherwise return -1.
 * Note:
 * 1. If there exists a solution, it is guaranteed to be unique.
 * 2. Both input arrays are non-empty and have the same length.
 * 3. Each element in the input arrays is a non-negative integer.
 *
 * @author BorisMirage
 * Time: 2019/06/18 15:13
 * Created with IntelliJ IDEA
 */

public class CanCompleteCircuit_134 {
    /**
     * Use pointer to store the start position.
     * If current tank can not cover the cost at current station, set start location at next point.
     *
     * @param gas  amount of gas
     * @param cost cost of gas
     * @return starting station's index if it can travel around the circuit once in the clockwise direction
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        /* Corner case */
        if (gas.length == 1) {
            return (gas[0] >= cost[0]) ? 0 : -1;
        }

        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
            tank = tank + gas[i] - cost[i];
        }

        if (tank < 0) {
            return -1;      // total gas can not cover total cost
        }

        /* There will be a solution, try from beginning */
        int start = 0;
        tank = 0;

        for (int i = 0; i < gas.length; i++) {

            tank = tank + gas[i] - cost[i];

            /* Reset location and tank */
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }

        return start;
    }
}
