class Solution {
    public int maxSubArray(int[] nums) {
        int total = 0;
        int ans = nums[0];
        
        for (int n : nums) {
            // If total = '-ve' restart
            if(total < 0){
                total = 0;
            }

            total += n;
            ans = Math.max(ans, total);
        }
        return ans;
    }
}