 class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum = 0;
        
        for(int x : arr)
            sum = sum + x;
        
        int ans = sum/3;
        int count = 0;
        int res = 0;
        
        if(sum % 3 != 0)
            return false;
        
        else{
            
            for(int i=0; i<arr.length; i++)
            {
                count = count + arr[i];
                if(count == ans)
                {
                    res++;
                    count = 0;
                }       
            }
        }
        return (res >= 3); 
    }
}