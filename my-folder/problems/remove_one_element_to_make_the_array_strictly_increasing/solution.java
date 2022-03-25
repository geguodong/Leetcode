class Solution {
    public boolean canBeIncreasing(int[] nums) {
        
        boolean canRemoveItem = true;
        int last=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=last){
                // we did not remove any item before
                if(canRemoveItem){
                    canRemoveItem=false;
                   
                    // if i is the last item just remove it
                    if(i==nums.length-1) return true;
                    
                    // Note : need to make sure nums[i] > nums[i - 2]
                    // can remove item at index i
                    if(nums[i+1]>nums[i-1]){
                        last=nums[i-1];
                    // can remove item at index i-1
                    } else if(nums[i+1]>nums[i] && (i-2<0 || nums[i]>nums[i-2])){
                        last=nums[i];
                    }else {
                        return false;
                    }
                    
                }else{
                    return false;
                }
            }else{
                last=nums[i];
            }
        }
        
        return true;
    }
}
