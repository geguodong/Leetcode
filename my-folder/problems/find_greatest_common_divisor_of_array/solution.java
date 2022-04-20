class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[0],nums[nums.length-1]);
    }
    public static int gcd(int m,int n){
        while(m!=n){
            if(m>n)m=m-n;
            else n=n-m;
        }
        return m;
    }
}