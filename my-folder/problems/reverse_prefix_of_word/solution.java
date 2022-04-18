class Solution {
    public String reversePrefix(String word, char ch) {
    	StringBuilder res = new StringBuilder();
    	int prefix = word.indexOf(ch);
    	String suffix = word.substring(prefix + 1);
    	while (prefix >= 0 ) {
    		res.append(word.charAt(prefix--));
    	}
        return res.append(suffix).toString();
    }
}