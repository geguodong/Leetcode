class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {          
            // c 是移入窗口的字符
            char c = s.charAt(right);
            // 窗口右移
            right++;
            // 更新窗口的一系列数据
            window.put(c, window.getOrDefault(c, 0) + 1);

                // 判断左侧窗口是否需要收缩
                while (window.get(c) > 1) {
                    // d 是移出窗口的字符
                    char d = s.charAt(left);
                    // 窗口右移
                    left++;
                    // 更新窗口的一系列数据
                    window.put(d, window.get(d) - 1);
                }
                // 这里更新最长子串的长度
                int len = right - left;
                res = Math.max(res, len);
        }
        return res;
    }
}
