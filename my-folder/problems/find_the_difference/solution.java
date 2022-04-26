class Solution {
    public char findTheDifference(String s, String t) {
        int originalCount = 0;
        int newCount = 0;
        for(int i=0;i< s.length();i++) {
            originalCount+=(int)s.charAt(i);
        }
        for(int j=0;j<t.length();j++) {
            newCount+=(int)t.charAt(j);
        }
        return (char)(newCount-originalCount);
    }
}