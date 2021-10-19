// O(n) O(n)
public class Solution {
    public int numSplits(String s) {
        int length = s.length();
        if(length < 2)
            return 0;

         if(length == 2)
            if(s.charAt(0) == s.charAt(1))
                return 1;

        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        //set up 2 hashmaps
        hm.put(s.charAt(0), 1);
        for(int i = 1; i < length; ++i)
            hm2.put(s.charAt(i), hm2.getOrDefault(s.charAt(i), 0) + 1);

        //check if the above set up is a good way
        int count = 0;
        if(hm2.size() == hm.size())
            ++count;

        //use a pointer and adjust the count of character occurences in the 2 hashmaps accordingly.
        for(int i = 1; i < s.length()-1; ++i)
        {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            int temp = hm2.get(s.charAt(i))-1;
            if(temp > 0)
                hm2.put(s.charAt(i), temp);
            else
                hm2.remove(s.charAt(i));

            if(hm2.size() == hm.size()) //same number of distinct characters
                ++count;
        }

        return count;
    }
    
}