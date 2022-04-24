class Solution {
    public String digitSum(String s, int k) {
        StringBuilder stb = new StringBuilder();
        int temp = 0;
        while(s.length() > k) {
            stb.setLength(0);
            for(int i = 0; i < s.length(); i += k) {
                temp = 0;
                for(int j = i; j < i + k && j < s.length(); j++) {
                    temp += s.charAt(j) - '0';
                }
            stb.append(temp);
        }
        s = stb.toString();
        }
        return s;
    }
}