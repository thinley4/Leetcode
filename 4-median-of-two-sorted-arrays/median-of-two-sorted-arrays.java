class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        double ans = 0.0;
        for(int i=0; i<nums1.length; i++) {
            res[i] = nums1[i];
        }
        for(int i=0; i<nums2.length; i++) {
            res[nums1.length + i] = nums2[i];
        }
        Arrays.sort(res);

        // find median
        int n = res.length;
        if(n % 2 == 0) {
            ans = (res[n/2] + res[n/2 - 1]) / 2.0;
        } else {
            ans = res[n/2];
        }
        return ans;
    }
}