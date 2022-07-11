// Hashmap + DoubleLinkedList
// O(1) O(capacity)
class LRUCache {
    
    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
    }
    
    private void addNode(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addNode(node);
    }
    
    private DLinkNode popTail() {
        DLinkNode node = tail.prev;
        removeNode(node);
        return node;
    }
    
    int size = 0;
    HashMap<Integer, DLinkNode> cache = new HashMap<>();
    int capacity;
    private DLinkNode head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        DLinkNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if(node == null) {
            DLinkNode newNode = new DLinkNode();
            newNode.key = key;
            newNode.value = value;
            addNode(newNode);
            cache.put(key, newNode);
            
            size++;
            if(size > capacity) {
                DLinkNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
           node.value = value;
           moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */