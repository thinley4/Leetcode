class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // sort based on last index
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int prev_end = intervals[0][1];
        int count = 0;

        // iterate from 1 index
        for(int curr=1; curr < intervals.length; curr++) {
            if(prev_end > intervals[curr][0]) {
                count++;
            } else {
                // valid / non-overlapping
                prev_end = intervals[curr][1];
            }
        }
        
        return count;
    }
}