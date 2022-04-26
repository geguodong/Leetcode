class Solution {
    static boolean isValid(int[] nums, int x){
        int start=0;
        int end= nums.length-1;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(nums[mid]<x)
                start= mid+1;
            else
                end= mid-1;
        }
        return nums.length-1-end == x;
    }
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int x= 0; x<= nums.length; x++)
            if(isValid(nums, x))
                return x;
        return -1;
    }
}
