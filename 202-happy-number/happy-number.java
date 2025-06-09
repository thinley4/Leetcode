class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();

        // run until digit not present in hashset
        // not a happy number
        while(!visit.contains(n)) {
            visit.add(n);
            n = getNextNumber(n);
            if(n == 1) {
                // happy number
                return true;
            }
        }
        // present in hashset
        return false;
    }
    public int getNextNumber(int n) {
        int sum = 0;
        // if n == 0 then found all digits  
        while(n > 0) {
            int digit = n % 10;
            sum = sum + (digit * digit);
            n = n / 10;
        }
        return sum;
    }
}