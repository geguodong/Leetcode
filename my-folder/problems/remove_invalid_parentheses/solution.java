class Solution {
    
    Set<String> validExpressions = new HashSet<>();
    int minRemoved;
    private void reset() {
        this.validExpressions.clear();
        this.minRemoved = Integer.MAX_VALUE;
    }
    
    private void recurse(String s, int index, int leftP, int rightP, StringBuilder current, int removeCount) {
        // when go to last 
        if(index == s.length()) {
            // valid expression
            if(leftP == rightP) {
                // valid answer
                if(removeCount <= minRemoved) {
                    String possibleAnswer = current.toString();
                    // new length
                    if(removeCount < minRemoved) {
                        reset();
                        minRemoved = removeCount;
                          
                    }
                    this.validExpressions.add(possibleAnswer);
                }
            }
        } else {
            char currentCharacter = s.charAt(index);
            int length = current.length();
            // If the current character is neither an opening bracket nor a closing one,
            // simply recurse further by adding it to the expression StringBuilder
            if(currentCharacter != '(' && currentCharacter != ')') {
                current.append(currentCharacter);
                recurse(s, index + 1, leftP, rightP, current, removeCount);
                current.deleteCharAt(length);
            } else {
                // Recursion where we delete the current character and move forward
                this.recurse(s, index + 1, leftP, rightP, current, removeCount + 1);
                
                // add it to current
                current.append(currentCharacter);
                
                // If it's an opening parenthesis, consider it and recurse
                if (currentCharacter == '(') {
                    this.recurse(s, index + 1, leftP + 1, rightP, current, removeCount);
                } else if (rightP < leftP) {
                // For a closing parenthesis, only recurse if right < left
                    this.recurse(s, index + 1, leftP, rightP + 1, current, removeCount);
                }
                
                // delete it to current
                current.deleteCharAt(length);
                
                
            }
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        reset();
        recurse(s, 0, 0, 0, new StringBuilder(), 0);
        return new LinkedList<String>(validExpressions);
    }
}