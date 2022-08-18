class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumCost = Arrays.stream(cost).sum();
        int sumGas = Arrays.stream(gas).sum();
        if (sumCost > sumGas) {
            return -1;
        }

        int index = 0, gasTank = 0;

        for (int i = 0; i < gas.length; i++) {
            gasTank += gas[i] - cost[i];
            if (gasTank < 0) {
                gasTank = 0;
                index = i + 1;
            }
        }

        return sumGas >= sumCost ? index : -1;
    }
}