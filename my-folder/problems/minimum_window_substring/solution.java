class Solution {
    public String minWindow( String s, String t ) {
        String res = "";
        if ( t.length() > s.length() ) {
            return res;
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for ( int i = 0; i < t.length(); i++ ) {
            char ch = t.charAt( i );
            need.put( ch, need.getOrDefault( ch, 0 ) + 1 );
        }
        int l = 0;
        int r = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while ( r < s.length() ) {
            char ch = s.charAt( r );
            r++;
            if ( need.containsKey( ch ) ) {
                window.put( ch, window.getOrDefault( ch, 0 ) + 1 );
                if ( window.get( ch ).equals( need.get( ch ) ) ) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while ( valid == need.size() ) {
                // 在这里更新最小覆盖子串
                if ( r - l < len ) {
                    start = l;
                    len = r - l;
                }
                // d 是将移出窗口的字符
                char d = s.charAt( l );
                // 左移窗口
                l++;
                // 进行窗口内数据的一系列更新
                if ( need.containsKey( d ) ) {
                    if ( window.get( d ).equals( need.get( d ) ) ) {
                        valid--;
                    }
                    window.put( d, window.get( d ) - 1 );
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring( start, start+len );
    }
}