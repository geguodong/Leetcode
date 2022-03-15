class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat[0].length;
        int j=0;
        int k=n-1;
        int ps=0;
        int ss=0;
        for(int i=0;i<n;i++)
        {
            ps+=mat[i][j];
            j++;
            ss+=mat[i][k];
            k--;
        }
        if(n%2==0)
            return ps+ss;
        else
            return ps+ss-mat[n/2][n/2];
    }
}