class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        // Majority element should be at the center of array
        return nums[len/2];
    }
}