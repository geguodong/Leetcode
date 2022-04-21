class Solution {
    public String[] findWords(String[] words) {
      
        String[] row = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> ls=new ArrayList<>();
        int r1 = 0,r2 = 0,r3 = 0;
        for (int i = 0; i < words.length; i++) {
            r1 = words[i].length();
            r2 =r1;
            r3 =r1;
            for (String st : words[i].toLowerCase().split("")) {
                if (row[0].contains(st)) {
                    r1--;
                }else if (row[1].contains(st)) {
                    r2--;
                }else if (row[2].contains(st)) {
                    r3--;
                }

            }
            if (r1 == 0 || r2 == 0 || r3 == 0)
                ls.add(words[i]);
        }
        return ls.toArray(new String[ls.size()]);
        
    }
}