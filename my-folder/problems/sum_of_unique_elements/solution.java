class Solution {
    public int sumOfUnique(int[] nums) {
        int [] arr = new int [101];
        int sum=0;
        
        for(int n: nums){
            arr[n]++;
            if(arr[n]==1) sum+=n;
            else if(arr[n]==2) sum-=n;
        }

        return sum;
    }
}