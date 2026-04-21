class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for(int n : nums) {
            if(map.get(n) == null) {// no key
                map.put(n, 1);
            } else {
                // key found
                map.put(n, map.get(n)+1);
            }
        }

        List<Integer> result = new ArrayList<>();
        int threshold = len/3;

        for(Integer key : map.keySet()) {
            if(map.get(key) > threshold){
                result.add(key);
            }
        }

        return result;
    }
}