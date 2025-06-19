class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix_arr = new int[n];
        int[] suffix_arr = new int[n];

        // Initialize prefix and suffix array with 1
        for(int i=0; i<n; i++) {
            prefix_arr[i] = 1;
            suffix_arr[i] = 1;
        }

        // get left multiplication for each index
        int prefix = 1;
        for(int i=0; i<n; i++) {
            prefix_arr[i] = prefix;
            prefix = prefix * nums[i];
        }

        // get right multiplication for each index
        // reverse array iteration
        int suffix = 1;
        for(int i=n-1; i>=0; i--) {
            suffix_arr[i] = suffix;
            suffix = suffix * nums[i];
        }
        // printArr(suffix_arr);

        // multiply suffix and prefix array and return
        for(int i=0; i<n; i++) {
            suffix_arr[i] = suffix_arr[i] * prefix_arr[i];
        }

        return suffix_arr;
    }
}