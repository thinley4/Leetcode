class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] cache = new int[n+1];
        cache[n-1] = nums[n-1]; // copy last element in cache

        for(int i=n-2; i>=0; i--) {
            int steal = nums[i] + cache[i+2];
            int dsteal = cache[i+1];

            cache[i] = Math.max(steal, dsteal);
        }
        
        return cache[0];
    }
}