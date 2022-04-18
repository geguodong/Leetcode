class Solution {
    public int minimumMoves(String s) {
        int i=0;int count=0;
        String str="";
        while(i<s.length()-2) {
            if(s.charAt(i)=='O') {
                i++;
                continue;
            }
            count++;
            i += 3;
        }
        str=s.substring(i,s.length());
        if(str.contains("X")) {
            count++;
        }  
        return count;
    }
}