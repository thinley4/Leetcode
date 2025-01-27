class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        makeCombination(candidates, target, 0, new ArrayList<>(), 0, res);
        return res;
    }

    private void makeCombination(int[] candidates, int target, int idx, List<Integer> comb, int total, List<List<Integer>> res) {
        // if total (combination of elem) equals to target
        if(total == target) {
            res.add(new ArrayList<>(comb));
            return;
        }
        // if total is greater than target OR index out of bound
        if(total > target || idx >= candidates.length) {
            return;
        }
        comb.add(candidates[idx]); // Store element
        makeCombination(candidates, target, idx, comb, total + candidates[idx], res); // Store same element
        comb.remove(comb.size()-1); // remove last element
        makeCombination(candidates, target, idx + 1, comb, total, res); // Check next element in array '+1'
    }
}