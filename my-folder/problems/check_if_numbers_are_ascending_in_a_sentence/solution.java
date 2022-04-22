class Solution {
    public boolean areNumbersAscending(String s) {
        int pr = 0;
        String[] st = s.split(" ");
        for (String ss : st) {
            if (Character.isDigit(ss.charAt(0))) {
                int number = Integer.parseInt(ss);
                if (number <= pr) return false;
                pr = number;
            }
        }
        return true;
    }
}