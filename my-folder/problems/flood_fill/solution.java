/*
Time Complexity: O(N)O, where NN is the number of pixels in the image. We might process every pixel.
Space Complexity: O(N), the size of the implicit call stack when calling dfs.
*/
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) {
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }
    
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r - 1, c, color, newColor);
            if (c >=1) dfs(image, r, c - 1, color, newColor);
            if (r < image.length - 1) dfs(image, r + 1, c, color, newColor);
            if (c < image[0].length - 1) dfs(image, r, c + 1, color, newColor);
        }
    }
}