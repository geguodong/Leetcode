class Solution {
    public boolean squareIsWhite(String coordinates) {
        
        int row = coordinates.charAt(0)-'a';
        int column = coordinates.charAt(1)-'0';
        
        int result = row+column;
        
        if(result%2==0)
            return true;
        return false;
        
    }
}