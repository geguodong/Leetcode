// Merge first, then search median
// O(m + n) O(m + n)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int len=m+n;
        int[] result=new int[len];
        int i=0,j=0,index=0;
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                result[index++]=nums1[i++];
            }else{
                result[index++]=nums2[j++];
            }
        }
        while(i<m){
            result[index++]=nums1[i++];
        }
        while(j<n){
            result[index++]=nums2[j++];
        }
        int median=len/2;
        double ans=0;
        if(len%2==0){
            ans=(result[median-1]+result[median])/2.0;
        }else{
            ans=result[median];
        }
        return ans;
    }
}