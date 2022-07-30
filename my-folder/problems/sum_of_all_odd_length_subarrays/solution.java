class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sumf=0;

        for(int i=0;i<arr.length;i++){
                int sumx=0,k=1;
                for(int j=i;j<arr.length;j++){
                    sumx+=arr[j];

                    if(k%2!=0){
                        sumf+=sumx;
                    }
                    k++;   
                }
            }
         return sumf;
    }
}