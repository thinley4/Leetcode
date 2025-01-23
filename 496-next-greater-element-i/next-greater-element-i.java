class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Initialize array equal to size of nums1. It should  store answer
        // Iterate in nums1
        // Take that int from nums1 and find it in nums2
        // And check that int in nums2
        // If found find the greater element and return
        // If not return -1
        
        int lenNums1 = nums1.length;
        int[] ans = new int[lenNums1];
        // int arrIndex = 0; // Keep track of index of ans array
        // Iterate in nums1
        for(int i=0; i<lenNums1; i++) {
            boolean found = false;
            boolean greaterFound = false;
            // Check nums1 value in nums2
            for(int j=0; j<nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    found = true;
                    // check element in right for greater
                    for(int k=j+1; k<nums2.length; k++) {
                        if(nums2[k] > nums1[i]) {
                            ans[i] = nums2[k]; // Store greater
                            greaterFound = true;
                            break;
                        }
                    }
                    // If no greater elem found store -1
                    if(!greaterFound) {
                        ans[i] = -1;
                    }
                    break;
                }
                // if nums1 not in nums2 set -1
                if(!found) {
                    ans[i] = -1;
                }
            }
        }
        return ans;
    }
}