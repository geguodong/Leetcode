class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        if (row * col != r * c) return mat;
        int[][] matrix = new int[r][c];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int index = i * col + j;
                matrix[index/c][index%c] = mat[i][j];
            }
        }
        return matrix;
    }
}