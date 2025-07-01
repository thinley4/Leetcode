class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // compare prefix of gas and cost
        int n = gas.length;
        int prefixSumGas = 0;
        int prefixSumCost = 0;

        for(int i=0; i<n; i++) {
            prefixSumGas += gas[i];
            prefixSumCost += cost[i];
        }

        if(prefixSumGas < prefixSumCost)
            return -1;
        
        // prefix sum of gas is not smaller then prefix sum of cost

        int currVal = 0;
        int start = 0;
        for(int i=0; i<n; i++) {
            currVal += gas[i]-cost[i];

            // if don't have enought fuel to go next place
            // change start index to (i+1) & Initialize currVal = 0
            if(currVal < 0) {
                start = i+1;
                currVal = 0;
            }
        }
        return start;
    }
}