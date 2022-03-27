class Solution {
    public int findTheDistanceValue(int[] a, int[] b, int d) {
        int count=0;
        for(int i=0;i<a.length;i++){
            int local=0;
            for(int j=0;j<b.length;j++)if(Math.abs(a[i]-b[j])>d)  local++;
            if(local==b.length)count++;
        }      return count;
    }
}