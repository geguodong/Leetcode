class Solution {
    public int maxDistance(int[] colors) {
        
        int num1 = -1;
        int num2 = -1;
        
        int j = colors.length - 1;
        int i = 0;
        
        while(i < j)
        {
          if(colors[i] != colors[j]){
             num1 = Math.abs(i - j);
              break;
          }
            else{
                i++;
            }
        }
        
        int j1 = colors.length - 1;
        int i1 = 0;
        
         while(i1 < j1)
         {
          if(colors[i1] != colors[j1]){
              num2 = Math.abs(i1 - j1);
              break;
          }
            else{
                j1--;
            }
        }
        
        return Math.max(num1 ,num2);
    }
}