class Solution {
    public String restoreString(String s, int[] indices) {
        char[] sol = new char[s.length()];
        for(int i = 0;i<sol.length;i++){
            sol[indices[i]] = s.charAt(i);
        }
        return new String(sol);
    }
}