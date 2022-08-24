class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;
        
        char[][] flippedBox = new char[cols][rows];
        
        for(int i = 0; i < rows; i++) {
            int lastEmpty = cols - 1;
            for(int j = cols - 1; j >= 0; j--) {
                
                flippedBox[j][rows - 1 - i] = '.';
                if(box[i][j] == '#') {
                    flippedBox[lastEmpty][rows - 1 - i] = '#';
                    lastEmpty--;
                } else if(box[i][j] == '*') {
                    lastEmpty = j - 1;
                    flippedBox[j][rows - 1 - i] = '*';
                }
                
            }
        }
        return flippedBox;
    }
}