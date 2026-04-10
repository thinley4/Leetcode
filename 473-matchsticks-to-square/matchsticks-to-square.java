class Solution {
    public boolean makesquare(int[] matchsticks) {
        int len = matchsticks.length;
        int sum = 0;
        for(int i=0; i<len; i++) {
            sum += matchsticks[i];
        }

        if(sum%4 != 0) return false;

        // array sorted and traverse from large element to avoid TLE
        Arrays.sort(matchsticks);
        boolean ans = match(matchsticks, len-1, 0, 0, 0, 0, sum/4);
        return ans;
    }
    public boolean match(int[] matchsticks, int index, int left, int top, int right, int bottom, int target){
        // success condition
        if(left == target && top == target && right == target && bottom == target)
            return true;
        
        // fail condition
        if(left > target || top > target || right > target || bottom > target)
            return false;

        int val = matchsticks[index];

        // traverse all 4 sides
        boolean l = match(matchsticks, index-1, left+val, top, right, bottom, target);
        if(l) return true;
        boolean t = match(matchsticks, index-1, left, top+val, right, bottom, target);
        if(t) return true;
        boolean r = match(matchsticks, index-1, left, top, right+val, bottom, target);
        if(r) return true;
        boolean b = match(matchsticks, index-1, left, top, right, bottom+val, target);
        if(b) return true;

        return false;
    }
}