class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cur = 0;
        while (cur < flowerbed.length) {
            if (flowerbed[cur] == 0) {
                if ((cur == 0 || flowerbed[cur - 1] == 0) && (cur == flowerbed.length - 1 || flowerbed[cur + 1] == 0)) {
                    n--;
                    cur ++; // careful
                }
            } 
            cur++;
        }
        return n <= 0;
    }
}