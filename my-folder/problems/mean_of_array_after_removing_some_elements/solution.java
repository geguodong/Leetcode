class Solution {
    public double trimMean(int[] arr) {
        
        int removal = arr.length / 20;
        double avg = 0.0;
        Arrays.sort(arr);
        
        for (int i = removal; i < arr.length - removal; i++)
        {
            avg = avg + (double)arr[i];
        }
        
        return avg / (arr.length - (removal * 2));
    }
}