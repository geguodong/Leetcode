// O(mn) O(1)
class Solution {
    public int strStr(String haystack, String needle) {
	    if(haystack == null || haystack.length() == 0) return -1;
        if(needle == null || needle.length() == 0) return 0;
	
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for(j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }
}