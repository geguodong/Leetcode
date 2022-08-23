class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }
        
        int length = beginWord.length();
        
        // pre-processing wordList
        HashMap<String, List<String>> wordDir = new HashMap<>();
        for(String word : wordList) {
            for(int i = 0; i < length; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> list = wordDir.getOrDefault(newWord, new ArrayList<String>());
                list.add(word);
                wordDir.put(newWord, list);
            }
        }
        
        // visited hashSet for circle
        Set<String> visited = new HashSet<>();
        
        // Queue for bfs
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        
        while(!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int level = pair.getValue();
            
            for(int i = 0; i < length; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
                for(String dirWord : wordDir.getOrDefault(newWord, new ArrayList<>())) {
                    if(dirWord.equals(endWord)) {
                        return level + 1;
                    }
                    if(!visited.contains(dirWord)) {
                        visited.add(dirWord);
                        queue.add(new Pair(dirWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}