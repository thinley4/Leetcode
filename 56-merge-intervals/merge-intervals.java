class Solution {
    public int[][] merge(int[][] intervals) {
        // 1. sort array based on 0th index
        Arrays.sort(intervals, (row1, row2) -> Integer.compare(row1[0], row2[0]));
        // 2. compare curr[0] and previous[1]
        // if curr[0] <= prev[1]
        // merge prev[0], curr[1]   
        // else, prev = curr (update prev)

        // intervals = [[1,3],[2,6],[8,10],[15,18]]
        List<int[]> ans = new ArrayList<>();
        int[] prev = intervals[0];
        int curr = 1;

        while(curr < intervals.length) {
            if(intervals[curr][0] <= prev[1]) { // 2 <= 3
                // update prev
                prev[1] = Math.max(prev[1], intervals[curr][1]);
            } else {
                // if not store in ans & update prev
                ans.add(prev);
                prev = intervals[curr];
            }
            curr++;
        }
        ans.add(prev);

        return ans.toArray(new int[ans.size()][]);
    }
}