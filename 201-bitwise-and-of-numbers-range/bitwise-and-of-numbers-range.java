class Solution {

// The trick here is that :
// Bitwise-AND of any two numbers will always produce a number less than or equal to the smaller number.

    public int rangeBitwiseAnd(int left, int right) {
        while(right > left) {
            right &= right - 1;
        }
        return right;
    }
}