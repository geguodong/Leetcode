class Solution {
    public int countLargestGroup(int n) {
        int[] sumMapBasic = new int[36 + 1]; //max num is 9999 -> sum is 36 + 1 for keep same idx
        int max = 0, largestGroupCount = 0;
        
        for (int i = 1; i <= n; i++) {
            int sum = sumOfDigits(i);
            sumMapBasic[sum]++;
            max = Math.max(max,sumMapBasic[sum]);
        }
        
        for (int count : sumMapBasic) {
            if (max == count) largestGroupCount++;
        }
        
        return largestGroupCount;
    }
    
    private int sumOfDigits(int n) {
        int sumOfDigits = 0;
        while (n != 0) {
            sumOfDigits += n % 10;
            n /= 10;
        }
        return sumOfDigits;
    }
}