class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] pops = new int[101];
        
        for(int[] arr: logs)
        {
            int a = arr[0];
            int b = arr[1];
            
            pops[a - 1950] += 1;
            pops[b - 1950] -= 1;
        }
        
        int maxPop = pops[0];
        int maxYear = 1950;
        
        for(int i = 1; i < pops.length; ++i)
        {
            pops[i] += pops[i - 1];         //prefix sum
            
            if(maxPop < pops[i])
            {
                maxPop = pops[i];
                maxYear = i + 1950;
            }
        }
        
        return maxYear;
    }
}