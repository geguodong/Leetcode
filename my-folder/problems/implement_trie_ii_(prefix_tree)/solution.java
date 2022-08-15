class TrieNode {
    char c;
    int counter;
    int end;
    TrieNode[] children;
    
    public TrieNode(char c){
        this.c = c;
        this.counter = 0;
        this.end = 0;
        this.children = new TrieNode[26];
    }
    
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode('\0');
    }
    
    public void insert(String w) {
        TrieNode curr = root;
        for(int i=0;i<w.length();i++){
            if(curr.children[w.charAt(i)-'a'] == null){
                curr.children[w.charAt(i)-'a'] = new TrieNode(w.charAt(i));
            }
            curr = curr.children[w.charAt(i)-'a'];
            curr.counter++;
        }
        curr.end++;
    }
    
    public int countWordsEqualTo(String w) {
        TrieNode node = getNode(w);
        if(node == null){
            return 0;
        }
        return node.end;
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode node = getNode(prefix);
        if(node == null){
            return 0;
        }
        return node.counter;
    }
    
    public void erase(String w) {
        TrieNode curr = root;
        for(int i=0;i<w.length();i++){
            curr.children[w.charAt(i)-'a'].counter--;
            curr = curr.children[w.charAt(i)-'a'];
        }
        curr.end--;
    }
    
    public TrieNode getNode(String w){
        TrieNode curr = root;
        for(int i=0;i<w.length();i++){
            if(curr.children[w.charAt(i)-'a'] == null || curr.children[w.charAt(i)-'a'].counter ==0){
                return null;
            }
            curr = curr.children[w.charAt(i)-'a'];
        }
        return curr;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */