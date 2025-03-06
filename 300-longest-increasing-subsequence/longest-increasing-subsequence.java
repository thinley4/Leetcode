class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int n : nums) {
            // Add curr Element if the result array empty
            // OR curr Elem is Larger than last elem in an res array
            if(res.isEmpty() || res.get(res.size() - 1) < n) {
                res.add(n);
            } else {
                // Find the index to be replaced
                int idx = binarySearch(res, n);
                res.set(idx, n);
            }
        }
        return res.size();
    }

    // Binary Search
    private int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target == arr.get(mid)) {
                return mid;
            } else if(arr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}