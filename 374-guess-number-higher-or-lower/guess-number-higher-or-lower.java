/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;  //start from 1
        int end = n;    //till n
        int mid;      //our guess
        int pick;    //their pick
       //simple binary search logic
        while(start <= end){
            mid = start + (end - start) / 2;
            pick = guess(mid); //call the predefined method which compares mid and pick and returns values according to it
            if(pick == 0){
                return mid;   //if correct guess then return mid
            }
            if(pick == -1){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return 0;
    }
}