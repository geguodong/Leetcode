class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int mid = 0;

        while(l < r){
            mid = (l + r)/2;
            if(nums[mid] == target){
                list.add(mid);
                break;
            }
            if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid +1;
            }
        }

        int i = mid-1;
        int j = mid+1;

        while(0 <= i){
            if(nums[i] == target){
                list.add(i);
                i--;

            }
            else{
                break;
            }

        }
        while(j < nums.length){
            if(nums[j] == target){
                list.add(j);
                j++;

            }else{
                break;
            }

        }
        Collections.sort(list);
        return list;

    }
}

