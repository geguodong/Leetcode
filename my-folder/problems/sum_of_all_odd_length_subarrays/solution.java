class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int size = 1;
        int sum = 0;
        while(size <= arr.length){
            int curSum = 0;
            for(int i = 0; i < arr.length; i++){
                if(i <= size - 1){
                    curSum += arr[i];
                }
                else{
                    sum += curSum;
                    curSum += arr[i];
                    curSum -= arr[i - size];
                }
            }
            sum += curSum;
            size += 2;
        }
        return sum;
    }
}
// Time complexity: O(N * ((N+1)/2))
// N is the number of elements in arr
// Space complexity: O(1)