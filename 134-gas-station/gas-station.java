class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // iterate in all gas station
        int n = gas.length;
        int s = 0; // surplus
        int d = 0; // depicit
        int startStation = 0; // start station

        for(int i=0; i<n; i++) {
            s += gas[i];
            if(s >= cost[i])
                s -= cost[i]; // deduct cost
            else {
                d += (cost[i] - s);
                s = 0;
                startStation = i+1; // Change starting index
            }
        }
        return s >= d ? startStation : -1;
    }
}