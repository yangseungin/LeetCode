class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0, sumGas = 0, sumCost = 0, gasTank = 0;

        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            gasTank += gas[i] - cost[i];
            if (gasTank < 0) {
                gasTank = 0;
                index = i + 1;
            }
        }

        return sumGas >= sumCost ? index : -1;
    }
}