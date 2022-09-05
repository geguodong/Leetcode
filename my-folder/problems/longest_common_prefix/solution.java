class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int i = 1; i < strs.length; i++) {
            strs[i] = compare(strs[i - 1], strs[i]);
        }
        return strs[strs.length - 1];
    }
    
    public String compare(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return compare(s2, s1);
        }
        String res = "";
        
        int index = 0;
        while(index < s1.length()) {
            if(s1.charAt(index) != s2.charAt(index)) {
                System.out.println("res : " + s1.charAt(index));
                res = s1.substring(0, index);
                return res;
            } else {
                index++;
            }
        }
        res = s1.substring(0, index);
        System.out.println("res : " + res);
        return res;
        
    }
}