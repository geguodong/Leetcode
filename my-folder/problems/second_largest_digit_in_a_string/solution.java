class Solution {
    public int secondHighest(String s) {
        HashSet<Integer> set = new HashSet<>();
        
        for(char c : s.toCharArray())
            if(Character.isDigit(c))
                set.add(Character.getNumericValue(c));
        
        List<Integer> list = new ArrayList<>(set);
        
        Collections.sort(list);
        
        if(list.size() <= 1)
            return -1;
        
        return list.get(list.size() - 2);
    }
}