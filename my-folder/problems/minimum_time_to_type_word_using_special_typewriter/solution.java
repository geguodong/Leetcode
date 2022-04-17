class Solution {
    public int minTimeToType(String word) {
        int time = word.length();    // the time taken to print each character
        char prev = 'a';
        for(char c : word.toCharArray()){
            int dif = Math.abs(c - prev);
            time += Math.min(dif, 26 - dif);    // time taken to move to next letter
            prev = c;
        }
        return time;
    }
}