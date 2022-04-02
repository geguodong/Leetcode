/*
class Solution {
    public boolean isValidPalindrome(String s, int k) {
        return isValidPalindrome(s, 0, s.length() - 1, k);
    }

    private boolean isValidPalindrome(String s, int left, int right, int k) {
        if (s == null || s.length() <= k + 1) return true;
        if (k < 0) return false;
        
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else { // need delete
                return isValidPalindrome(s, left, right - 1, k - 1) || isValidPalindrome(s, left + 1, right, k - 1);
            }
        }
        return true;
    }
}
*/

class Solution {
    public boolean isValidPalindrome(String s, int k) {
        if (s == null || s.length() <= k + 1) return true;

        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][len - 1] <= k;
    }
}