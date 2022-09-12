class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> stringSet = new HashSet<>();
        expansion(expression, stringSet);
        List<String> answer = new ArrayList<>(stringSet);
        Collections.sort(answer);
        return answer;
    }
    
    private void expansion(String expression, Set<String> set) {
        int end = expression.indexOf('}');
        if(end == -1) {
            set.add(expression);
            return;
        }
        int start = end;
        while(expression.charAt(start) != '{') {
            start--;
        }
        // Rule 1 Split by Comma
        String[] elements = expression.substring(start + 1, end).split(",");
        String preStart = expression.substring(0, start);
        String postEnd = expression.substring(end + 1);
        // Rule 2 Concat Multiple
        for(String current: elements) {
            expansion(preStart + current + postEnd, set);
        }
    }
}