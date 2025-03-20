class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // Sliding window + HashSet
        int n = nums.length;
        Set<Integer> elements = new HashSet<>();
        long currentSum = 0;
        long maxSum = 0;
        int begin = 0;

        for(int end = 0; end < n; end++) {
            // Not duplicate in window
            if(!elements.contains(nums[end])) {
                currentSum += nums[end];
                elements.add(nums[end]);

                // size equals to 3
                if(end - begin + 1 == k) {
                    maxSum = Math.max(maxSum, currentSum);
                    currentSum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
            // Duplicate in window
            } else {
                while(nums[begin] != nums[end]) {
                    currentSum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
                begin++;
            }
        }
        return maxSum;
    }
}