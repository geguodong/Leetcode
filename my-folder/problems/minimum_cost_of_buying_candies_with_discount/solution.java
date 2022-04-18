class Solution {
    public int minimumCost(int[] cost) {
        if(cost.length == 1) return cost[0];
        
        int price = 0, temp = 0, count = 0;
        
        //sorts the array
        Arrays.sort(cost);
         
        //takes the price of the two elements to the right, then skips a element, then repeates
        for(int i = cost.length -1; i >= 0; i--){
            count++;
            if(count == 3){
                count = 0;
            } else{
                price += cost[i];
            }
        }
        
        return price;
    }
}