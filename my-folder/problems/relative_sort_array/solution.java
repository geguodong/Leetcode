class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] out = new int[arr1.length]; 
        Queue<Integer> q = new LinkedList<>(); 
        HashMap<Integer , Integer> map = new HashMap<>() ; 
        for(int i : arr2){
            q.add(i); 
        }
        
        for(int i : arr1){
            map.put(i , map.getOrDefault(i , 0) + 1) ; 
        }
        
        int counter= 0 ; 
        
        while(!q.isEmpty()){
            int next = q.poll() ; 
            while(map.containsKey(next) && map.get(next) !=0){
                out[counter++] = next ; 
                map.put(next , map.get(next) - 1); 
            }
            map.remove(next); 
        }
        
        // remaining elements
        List<Integer> list = new ArrayList<>(map.keySet()); 
        Collections.sort(list); 
        
        for(Integer element : list){
            while(map.get(element)!=0){
                out[counter++] = element ; 
                map.put(element , map.get(element) - 1); 
            }
        }
        
        return out ; 
    }
}