class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for(int i = 0; i< nums.length; i++){
            if(numberOfValues(nums[i])%2 == 0){
                res++;
            }
        }
       return res;
        
    }
    private int numberOfValues(int n){
        int count = 0;
        while(n > 0){
             n = n/10;
            count++;
            
        }
        return count;
    }
}