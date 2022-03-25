class Solution {
    public static boolean findRotation(int[][] mat, int[][] target) {

        // max number of rotations is 4 --> 360 degrees

        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) //Checking two matrices are equal or not.
                return true;
            mat = rotateMatrix(mat);
        }
        return false;
    }
    // function to rotate the matrix.
    public static int[][] rotateMatrix(int[][] mat) {
        int n = mat.length;
        //create a new matrix called rotatedMat with the length of mat matrix to store the rotated matrix.
        int[][] rotatedMat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // new row = prev column
                // new column = n - 1 - prev row 
                rotatedMat[j][n - 1 - i] = mat[i][j];
            }
        }
        return rotatedMat;
    }

}