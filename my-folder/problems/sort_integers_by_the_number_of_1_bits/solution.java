class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] sorted = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) {
            sorted[i] = arr[i];
        }
        
        Arrays.sort(sorted, (a, b) -> {
            
            int numberOfBitsA = getBits(a);
            int numberOfBitsB = getBits(b);
            if(numberOfBitsA == numberOfBitsB) {
                return a - b;
            } else if(numberOfBitsA > numberOfBitsB) {
                return 1;
            }
            return -1;
       }
       );
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sorted[i];
        }
        return arr;
    }
    
    public int getBits(int a) {
        int res = 0;
        while(a > 0) {
            res += 1 & a;
            a >>= 1;
        }
        
        return res;
    }
}