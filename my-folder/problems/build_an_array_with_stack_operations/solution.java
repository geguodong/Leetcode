class Solution {
    public List<String> buildArray(int[] target, int n) {
        int start = 1;
        List<String> result  = new ArrayList<>();
        for(int i = 0; i < target.length; ) {
            if(target[i] == start)
            {
                result.add("Push");
                start++;
                i++;
            } else  {
                result.add("Push");
                result.add("Pop");
                start++;
            }
        }
        return result;
    }
}