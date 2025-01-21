class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int totalCandies = n; // Keep track of total candies
        int i=1;

        while(i < n) {
            // If prev and curr candies are same,
            // Simply move forward
            if(ratings[i] == ratings[i-1]){
                i++;
                continue;
            }
            int currentPeak = 0; // Keep track of additional candies in the increasing sequence
            // This while loop is for increasing sequence
            while(i<n && ratings[i] > ratings[i-1]) {
                currentPeak++;
                totalCandies += currentPeak;
                i++;
            }
            // If we reach the end of the array
            if(i == n){
                return totalCandies;
            }
            // When rating is decreasing
            int currentValley = 0; 
            while(i<n && ratings[i] < ratings[i-1]) {
                currentValley++;
                totalCandies += currentValley;
                i++;
            }
            // At the point where increasing sequence transistion into decreasing sequence, the child at the transistion is counted twice
            totalCandies -= Math.min(currentPeak, currentValley);
        }
        return totalCandies;
    }
}