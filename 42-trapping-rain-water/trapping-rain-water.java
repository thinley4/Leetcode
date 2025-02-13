class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;

        // When left is smaller than right
        while (left < right) {
            // when curr left max is smaller than curr right max
            if(leftMax < rightMax) {
                left++;
                // compare left max and curr left
                leftMax = Math.max(leftMax, height[left]);
                // water = leftmax - curr left
                water += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }
        return water; 
    }
}