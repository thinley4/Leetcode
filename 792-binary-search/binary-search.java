class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            } else if(target < nums[mid]){
                // target smaller than mid
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}