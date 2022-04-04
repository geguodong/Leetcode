class Solution {
    public int countKDifference(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
        int count=0;
        for(int i:nums) {
            if(h1.containsKey(i-k)) {
                count+=h1.get(i-k);       
            }
            h1.put(i,h1.getOrDefault(i,0)+1);
        }
        return count;
    }
}