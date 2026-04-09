class Solution {
    public int subsetXORSum(int[] nums) {
        return recur(nums, 0, 0);
    }

    public int recur(int[] nums, int start, int currentXor) {
        if(start==nums.length) return currentXor;

        int inc = recur(nums, start+1, currentXor^nums[start]);
        int exc = recur(nums, start+1, currentXor);

        return inc+exc;
    }
}