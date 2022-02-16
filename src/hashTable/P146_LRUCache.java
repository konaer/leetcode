package hashTable;

import java.util.Map;

public class P146_LRUCache {
	
	//0(1)时间get和put
	//空间 链表和哈希表，都是capacity + 1个长度
	class Dnode {
        int key, val;
        Dnode pre, next;
        Dnode() {};
        Dnode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Dnode head, tail;
    private Map<Integer, Dnode> cache = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Dnode();
        tail = new Dnode();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Dnode node = cache.get(key); 
        if (node == null) {
            return -1;
        } else {
            deleteNode(node);
            addNode(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        Dnode node = cache.get(key);
        if (node == null) {
            node = new Dnode(key, value);
            cache.put(key, node);
            addNode(node);
            if (cache.size() > capacity) {
            	//这里注意要先从哈希表删，如果先删node，哈希表里tail.pre已经变了
                cache.remove(tail.pre.key);
                deleteNode(tail.pre);
            }
        } else {
            deleteNode(node);
            node.val = value;
            addNode(node);
        }
    }

    private void deleteNode(Dnode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addNode(Dnode node) {
        node.pre = head;
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
    }
}
