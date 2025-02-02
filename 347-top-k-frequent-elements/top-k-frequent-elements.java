class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Store number with it's frequency in hashmap
        Map<Integer, Integer> counter = new HashMap<>();
        for(int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        // Create a Array (Index Represent frequency)
        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for(int i=0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        // Store element in bucket (Array)
        // freq[1] -> [3]
        // freq[2] -> [2]
        // freq[3] -> [1]
        for(Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int frequency = entry.getValue(); // Get freq
            freq[frequency].add(entry.getKey());
        }
        // Store top k highest freq element
        int[] res = new int[k];
        int idx = 0;
        for(int i=freq.length-1; i>=0; i--) {
            for(int num : freq[i]) {
                res[idx++] = num;
                if(idx == k) {
                    return res;
                }
            }
        }
        // When K is greater than the unique element in array
        return new int[0];
    }
}