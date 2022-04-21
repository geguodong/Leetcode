class Solution {
    public boolean checkString(String s) {
        int firstb = s.indexOf('b');
        if(firstb == -1)
            return true;
        for(int i = firstb; i < s.length(); i++)
            if(s.charAt(i) == 'a')
                return false;
        return true;
    }
}