class Solution {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        // divide n into as many 3's as possible
        int threes = n / 3;
        int remainder = n % 3;

        if(remainder == 1) {
            threes -= 1; // remove 3*1
            remainder = 4; // create 2 * 2
        } else if (remainder == 0) {
            remainder = 1;
        }

        return (int) (Math.pow(3, threes) * remainder);

    }
}