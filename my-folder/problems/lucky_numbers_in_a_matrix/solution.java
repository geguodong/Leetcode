class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<matrix.length; i++){
            int minId=0;
            int min=999999;
            
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    minId = j;
                }
            }
            boolean isTrue = true;
            for(int j=0; j<matrix.length; j++){
                if(matrix[i][minId] < matrix[j][minId]){
                    isTrue = false;
                    break;
                }
            }
            
            if(isTrue){
                arr.add(matrix[i][minId]);
            }
        }
        return arr;
    }
}