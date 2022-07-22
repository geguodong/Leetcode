class Solution {
    public int countVowelSubstrings(String word) {
        int ans=0;
        for(int i=0;i<word.length();i++) {
            HashMap<Character,Integer> memo = new HashMap<>();
            for(int j=i;j<word.length();j++) {                                                                  if(word.charAt(j)=='a'||word.charAt(j)=='e'||word.charAt(j)=='i'||word.charAt(j)=='o'||word.charAt(j)=='u') {
                memo.put(word.charAt(j),1);
                if(memo.size()==5){
                    ans+=1;
                }
            } else{
                break;
            }
        }
         
        }
        return ans;
    }
}
