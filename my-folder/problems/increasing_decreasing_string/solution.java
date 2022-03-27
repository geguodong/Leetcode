class Solution {
    public String sortString(String s) {    
        
        int [] map = new int [26];
        int total=s.length();
        for(int i=0;i<s.length();i++){
           map[s.charAt(i)-'a']++;
        }

        StringBuilder str = new StringBuilder();
        
        while(total>0){

        for(int i=0;i<map.length;i++){
            if(map[i]>0){
                map[i]--;
                total--;
                str.append((char) (i+'a'));
            }
        }

        for(int i=map.length-1;i>=0;i--){
            if(map[i]>0){
                map[i]--;
                total--;
                str.append((char) (i+'a'));
            }
        }
        }
        return str.toString();
    }
}