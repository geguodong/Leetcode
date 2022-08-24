class Solution {
    public String reorganizeString(String s) {
        //build a hashmap, represent each alphb's occurence in input string s
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        
        //find the letter with the most occurence
        int max = 0; //the max occurence 
        int letter = 0; //the letter / character with max occurence
        for (int i = 0; i < hash.length; i++) {
            if (max < hash[i]) {
                max = hash[i];
                letter = i;
            }
            
        }
        
        //check the corner case: 
        //when there is a letter with more than half of the s.length occurence, 
        //then must be impossible to satisfy the requirement
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        
        //iterate every character inside the hashmap
        char[] res = new char[s.length()];
        int index = 0;
        //set the position of the letter with most occurence first, and make sure each of them are seperated by one space
        while (hash[letter] > 0) {
            res[index] = (char) (letter + 'a');
            index += 2;
            hash[letter]--;
        }
        
        //insert other letters which are not the most occurence
        for (int i = 0; i < hash.length; i++) {
            //insert current character until it's occurence become 0
            while (hash[i] > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
                hash[i]--;
            }
        }
        
        return String.valueOf(res);
    }
}