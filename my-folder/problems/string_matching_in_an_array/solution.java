class Solution {
    public List<String> stringMatching(String[] words) {
         Set<String> result=new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if(words[i].contains(words[j]))
                    result.add(words[j]) ;
                if(words[j].contains(words[i]))
                    result.add(words[i]) ;
            }   
        }
        List<String> l1=new ArrayList<>(result);
       // l1.addAll(result);
        return l1;
    }
}