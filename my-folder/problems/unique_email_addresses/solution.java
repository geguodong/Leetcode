/*
O(m*n) O(n)
*/
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String[] name_domain = email.split("@");
            StringBuilder sb = new StringBuilder();
            for (char c : name_domain[0].toCharArray()) {
                if (c == '.') {
                    continue;
                } else if (c == '+') {
                    break;
                } else {
                    sb.append(c);
                }
            }
            sb.append("@"); // Carefull !!
            sb.append(name_domain[1]);
            uniqueEmails.add(sb.toString());
        }
        return uniqueEmails.size();
    }
}