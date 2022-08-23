class AutocompleteSystem {
    Map<String, Integer> map;
    class Trie{
        Trie[] links = new Trie[27];
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            int check = map.get(b)-map.get(a);
            if(check==0) {
                return a.compareTo(b);
            }   
            return check;
        });
    }
    
    Trie root;
    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new HashMap<>();
        root = new Trie();
        for(int i=0;i<times.length;i++) {
            insertIntotrie(sentences[i], times[i]);
        }       
    }
    
    public void insertIntotrie(String key, int val){
        map.put(key,val);
        Trie temp = root;
        for(char c: key.toCharArray()){
            int idx=0;
            if(c==' ') {
               idx=26;
            } else {
               idx = c-'a'; 
            }
                

            if(temp.links[idx]==null){
                temp.links[idx] = new Trie();
                temp = temp.links[idx];
                temp.pq.add(key);
            }else{
                temp = temp.links[idx];
                temp.pq.add(key);
            }
        }   
    }
    
    public void updateTrie(String key){
        Trie temp = root;
        for(char c: key.toCharArray()){
            int idx=0;
            if(c==' ') idx=26;
            else idx = c-'a';

            if(temp.links[idx]==null){
                temp.links[idx] = new Trie();
                temp = temp.links[idx];
                temp.pq.remove(key);
                temp.pq.add(key);
            }else{
                temp = temp.links[idx];
                temp.pq.remove(key);
                temp.pq.add(key);
            }
        }   
    }
    
    public void dfs(String key, List<String> result){
        Trie temp = root;
        for(char c: key.toCharArray()){
            int idx=0;
            if(c==' ') {
                idx=26;
            } else {
                idx = c-'a';
            }

            if(temp.links[idx]==null){
                return;
            } else {
                temp = temp.links[idx];
            }
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>(temp.pq);
        int i=0;
        while(i<temp.pq.size() && i<3){
            result.add(pq.poll());
            i++;
        }
    }

    StringBuilder in = new StringBuilder();
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if(c=='#'){
            if(map.containsKey(in.toString())){
                map.put(in.toString(), map.get(in.toString())+1);
                updateTrie(in.toString());
            } else {
                insertIntotrie(in.toString(), 1);
            }    
            in.setLength(0);
            return result;
        }
        
        in.append(c);
        dfs(in.toString(), result);
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */