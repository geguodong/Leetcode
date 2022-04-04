class Solution {
	public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr); 
        for(int i = arr.length - 2; i >= 0; --i){
            int dif0 = arr[1]-arr[0];
            if(arr.length==2)
                return true;
            else if ((arr[i+1]-arr[i])!=dif0)
                return false;
        }
        return true;
    }
}