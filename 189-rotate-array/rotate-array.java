class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        // if 'k' greater than len
        k = k % len;
        int[] res = new int[len];

        // store from 0th index
        int secondHalfIdx = len-k;
        for(int i=0; i<k; i++) {
            res[i] = nums[secondHalfIdx];
            secondHalfIdx++;
        }

        // store from second half
        int firstHalfIdx = 0;
        for(int i=k; i<len; i++) {
            res[i] = nums[firstHalfIdx];
            firstHalfIdx++;
        }

        for(int i=0; i<len; i++) {
            nums[i] = res[i];
        }
    }
}