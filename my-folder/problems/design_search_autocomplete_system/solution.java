class AutocompleteSystem {

    private Trie root;
    private Trie tmp; //tmp = current searching node
    private StringBuilder sb;
    private Map<String, Integer> tMap;
    public AutocompleteSystem(String[] sentences, int[] times) {
        sb = new StringBuilder();
        root = new Trie();
        tMap = new HashMap<>();
        tmp = root;

        int i = 0;
        for (String s : sentences){
            addWord(s, times[i++]); //call addWord function
        }
    }

    public List<String> input(char c) {
        List<String> ans = new ArrayList<>();
        if (c == '#'){
            addWord(sb.toString(), 1);
            sb.setLength(0);
            tmp = root;
            return ans;
        }

        if (tmp != null) {
            tmp = tmp.nodes[c];
        }
            
        sb.append(c);
        return tmp == null? List.of() : tmp.top;
    }

    private void addWord(String s, int cnt){
        tMap.put(s, tMap.getOrDefault(s, 0) + cnt);
        Trie cur = root;
        for (char ch : s.toCharArray()){
            if (cur.nodes[ch] == null) {
                cur.nodes[ch] = new Trie();
            }    
            cur = cur.nodes[ch];
            if (!cur.top.contains(s)) {
                cur.top.add(s);
            } 
            Collections.sort(cur.top, (a, b) -> {
                return tMap.get(a) == tMap.get(b)? a.compareTo(b) : tMap.get(b) - tMap.get(a);
            });
            if (cur.top.size() > 3) cur.top.remove(3); //remove the last one if needed. O(1) operation for removing the last element in a list
        }
    }

    private class Trie{
        Trie[] nodes;
        List<String> top;

        Trie(){
            nodes = new Trie[128];
            top = new ArrayList<>();
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */