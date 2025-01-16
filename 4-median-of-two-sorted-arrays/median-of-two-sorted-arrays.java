class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]){
                res[k] = nums1[i];
                k++;
                i++;
            } else {
                res[k] = nums2[j];
                k++;
                j++;
            }
        }

        // Add remaining element from nums1
        while(i < nums1.length){
            res[k] = nums1[i];
            k++;
            i++;
        }

        // Add remaining element from nums2
        while(j < nums2.length) {
            res[k] = nums2[j];
            k++;
            j++;
        }

        // Find median
        if((res.length % 2) == 0){
            return ( res[res.length / 2] + res[(res.length / 2) - 1] ) / 2.0; 
        } else {
            return res[res.length / 2];
        }
    }
}