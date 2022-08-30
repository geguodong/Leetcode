// Greddy + BFS
class Solution {
    public int kSimilarity(String s1, String tar) {
        Queue<String> q = new ArrayDeque<>();
        q.add(s1);
        
        int lvl = 0;
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                String s = q.remove();
                if(s.equals(tar)) {
                   return lvl; 
                }
                
                int i = 0;
                while(s.charAt(i) == tar.charAt(i)) {
                    i++;
                }   
                
                int j = i;
                while(j < s.length()){
                    if(s.charAt(j) == tar.charAt(i) && tar.charAt(j) != s.charAt(j)){
                        StringBuilder sb = new StringBuilder(s);
                        sb.setCharAt(i, s.charAt(j));
                        sb.setCharAt(j, s.charAt(i));
                        
						//A small optimization.
                        if(sb.toString().equals(tar)) {
                            return lvl+1;
                        }
                        q.add(sb.toString());
                    }
                    j++;
                }
            }
            lvl++;
        }
        return lvl;
    }
}