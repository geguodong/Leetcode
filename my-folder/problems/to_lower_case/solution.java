class Solution {
  public String toLowerCase(String str) {
    Map<Character, Character> h = new HashMap();
    String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower = "abcdefghijklmnopqrstuvwxyz";
    for (int i = 0; i < 26; ++i) {
      h.put(upper.charAt(i), lower.charAt(i));
    }

    StringBuilder sb = new StringBuilder();
    for (char x : str.toCharArray()) {
      sb.append(h.containsKey(x) ? h.get(x) : x);
    }
    return sb.toString();
  }
}