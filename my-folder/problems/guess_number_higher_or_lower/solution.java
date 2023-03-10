/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

/*
Time complexity : O(logn). Binary Search is used.
Space complexity : O(1). No extra space is used.
*/
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1; 
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}