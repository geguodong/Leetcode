class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> l=new ArrayList<>();
        HashSet<Integer> h1=new HashSet<>();
        HashSet<Integer> h2=new HashSet<>();
        for(int n:nums1){
            h1.add(n);
        }
        for(int n:nums2){
            h2.add(n);
        }
        List<Integer> f=new ArrayList<>();
        List<Integer> s=new ArrayList<>();
        for(int n:nums1){
            if(!h2.contains(n)&&!f.contains(n)){
                f.add(n);
            }
        }
        for(int n:nums2){
            if(!h1.contains(n)&&!s.contains(n)){
                s.add(n);
            }
        }
        l.add(f);
        l.add(s);
        return l;
    }
}