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

    static class Value {
        String val;
        int timestamp;
        Value(String val, int timestamp) {
            this.val = val;
            this.timestamp = timestamp;
        }
    }
    
    Map<String, List<Value>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Value v = new Value(value, timestamp);
        List<Value> list = map.getOrDefault(key, new ArrayList<>());
        list.add(v);
        map.put(key, list);
     //   map.computeIfAbsent(key, k -> new ArrayList<>()).add(v);
    }
    
    public String get(String key, int timestamp) {
        List<Value> values = map.get(key);
        if (values == null || values.size() == 0) {
            return "";
        }
        String res = "";
        int lo = 0;
        int hi = values.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (values.get(mid).timestamp <= timestamp) {
                res = values.get(mid).val;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
}