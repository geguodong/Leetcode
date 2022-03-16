/*
O(N)
O(1)
*/
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        int[] freq = new int[101];
        for( int i : nums){ // 1 step
            freq[i]++;
        }
        
        for ( int i = 1 ; i < freq.length ; i++){ // 2 step 
            freq[i] += freq[i-1];
        }
        
        int n = nums.length ; 
        for( int i = 0 ; i < n ;i++){ // step3 
            int val = nums[i];
			// modify the input arr itself instead of creating new one . no need for extra space 
            nums[i] = val == 0 ? 0 : freq[val - 1]; // sc if val == 0 , use 0 as its constraint to be lowest 
        }
        
        return nums ; 
    }
}