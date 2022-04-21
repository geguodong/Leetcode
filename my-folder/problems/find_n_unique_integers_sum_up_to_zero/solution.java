class Solution {
    public int[] sumZero(int n) {
        int arr[] = new int[n];
        
        int a = -1;
        int b = 1;
        
        if(n%2 == 0){
            for(int i=0; i<n/2; i++){
                arr[i] = a;
                a--;
            }    
            for(int i=n/2; i<n; i++){
                arr[i] = b;
                b++;
            }
        }
        
        if(n%2 == 1){
            arr[n/2] = 0;
            
            for(int i=0; i<n/2; i++){
                arr[i] = a;
                a--;
            }
            for(int i=(n/2)+1; i<n; i++){
                arr[i] = b;
                b++;
            }
        }
        
        return arr;
    
    }
}