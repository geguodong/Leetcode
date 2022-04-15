class Solution {
    public int minimumSum(int num) {
        int n[] = new int[4];
        int i = 0;
        while (num > 0) {
            n[i++] = num % 10;
            num /= 10;
        }
        Arrays.sort(n);
        
        return 10 * (n[0] + n[1]) + n[2] + n[3];

    }
}