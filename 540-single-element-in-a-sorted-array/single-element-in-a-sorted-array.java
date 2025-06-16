class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            // mid is odd, make to even
            if(mid % 2 == 1) 
                mid--;
            // mid always in even index
            // so, left & right sides are always even
            if(nums[mid] != nums[mid+1]) {
                // if mid not equals to (mid+1) 
                // right side is even
                // so, non-duplicate is at left side
                right = mid;
            } else {
                // if mid equals to (mid+1)
                // right side will be odd
                // Y can take eg and check
                left = mid + 2;
            }
        }
        // left or right, any works
        // return nums[left];
        return nums[right];
    }
}