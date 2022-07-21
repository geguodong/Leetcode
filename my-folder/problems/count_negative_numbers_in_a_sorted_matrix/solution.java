/*
O(mn)
O(1)
*/
class Solution {
    public int countNegatives(int[][] grid) {
        int rstart =0,rend=grid.length-1,cend = grid[0].length-1;
        int count =0;
        while(rstart<=rend&&cend>=0){
            if(grid[rstart][cend]<0){
                count+=(rend-rstart)+1;
                cend--;
            }
            else{
                rstart++;
            }
        }
        return count;
    }
}