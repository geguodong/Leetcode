// class TimeMap {

//     public TimeMap() {
        
//     }
    
//     public void set(String key, String value, int timestamp) {
        
//     }
    
//     public String get(String key, int timestamp) {
        
//     }
// }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */


class TimeMap {
    HashMap<String, TreeMap<Integer, String>> timer;
    public TimeMap() {
        timer = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap treemap = timer.getOrDefault(key, new TreeMap());
        treemap.put(timestamp, value);
        timer.put(key, treemap);
      //  timer.putIfAbsent(key, new TreeMap<>());
      //  timer.get(key).put(timestamp, value);
       
    }
    
    public String get(String key, int timestamp) {
        String get = "";
        if(timer.containsKey(key)){
            Integer floorKey;
            floorKey = timer.get(key).floorKey(timestamp);
            if(floorKey != null)
                get = timer.get(key).get(floorKey);
        }
        return get;
    }
}