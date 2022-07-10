// O(n) O(n)
class Solution {
    public int[] plusOne(int[] digits) {
        // check edge case
        if(digits == null || digits.length == 0) {
            return new int[]{1};
        }
        List<Integer> plusOne = new ArrayList<>();
        int isTen = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            if(isTen + digits[i] == 10) {
                plusOne.add(0, 0);
                isTen = 1;
            } else {
                plusOne.add(0, digits[i] + isTen);
                isTen = 0;
            }
        }
        
        // check first digit is 1
        if(isTen == 1) {
            plusOne.add(0, isTen);
        }
        
        int[] res = new int[plusOne.size()];
        for(int i = 0; i < plusOne.size(); i++) {
            res[i] = plusOne.get(i);
        }
        return res;
    }
}