class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String each : operations){
            switch (each){
                case "--X":
                case "X--":
                    x = x - 1;
                    break;
                case "X++":
                case "++X":
                    x = x+1;
                    break;
            }
        }
        return x;
    }
}