class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int r = 0;
        int total = 0;
        int left = 0;
        while(r < nums.length) {
            total += nums[r];
            // total greater or equal to target
            while(total >= target) {
                // no. of integer
                res = Math.min(res, r-left+1);
                // removing left element
                total = total-nums[left];
                left++;
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}