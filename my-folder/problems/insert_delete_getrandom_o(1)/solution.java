// HashMap + ArrayList
class RandomizedSet {
    Map<Integer, Integer> dict;
    List<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        dict = new HashMap();
        list = new ArrayList();        
    }
    
    public boolean insert(int val) {
        if (dict.containsKey(val)) return false;
    
        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }
    
    public boolean remove(int val) {
        if (! dict.containsKey(val)) return false;
        
      // move the last element to the place idx of the element to delete
      int lastElement = list.get(list.size() - 1);
      int idx = dict.get(val);
      list.set(idx, lastElement);
      dict.put(lastElement, idx);
      // delete the last element
      list.remove(list.size() - 1);
      dict.remove(val);
      return true;
        
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */