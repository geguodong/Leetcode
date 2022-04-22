class Solution {
    public int countCharacters(String[] words, String chars) {
        int len = 0;
        
        // freq
        int[] f = new int[26];
        for(int i = 0; i < chars.length(); i++){
            f[chars.charAt(i) - 'a']++;
        }
        
        // check each word
        for(String word : words){
            if(check(word, f)) len += word.length();
        }
        return len;
    }
    
    private boolean check(String word, int[] f){
        int[] w = new int[26];
        for(int i = 0; i < word.length(); i++){
            w[word.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(f[i] - w[i] < 0){
                return false;
            }
        }
        return true;
    }
}