class Solution {
     public int maxScore(String s) {
        int total_sum = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                total_sum += 1;
            }
        }
        int maxcount = 0;
        int running_sum = 0;
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == '1'){
                running_sum += 1;
            }
            int zeroinleft = i + 1 - running_sum;
            int oneinright = total_sum - running_sum;
            int score = zeroinleft + oneinright;
            if(maxcount < score){
                maxcount = score;
            }
        }
        return maxcount;
    }
}