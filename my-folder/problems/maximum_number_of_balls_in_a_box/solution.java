class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int [] freq=new int[50]; // or int[100001]; in range
        int max=0;
        for(int i=lowLimit;i<=highLimit;i++) {
            int count=0;
            int n=i;
            while(n>0) {
                count+=n%10;
                n=n/10;
            }

            freq[count]++;
            max = Math.max(max , freq[count]);   
        }
        return max;
    }
}