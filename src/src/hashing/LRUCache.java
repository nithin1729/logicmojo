package hashing;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLL {
        int key;
        int val;
        DLL prev;
        DLL next;

        DLL(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }

        DLL() {

        }
    }

    DLL head;
    DLL last;

    Map<Integer, DLL> map;
    int maxCapacity;
    int currCapacity;

    private void moveToFirst(DLL node) {
        if(node==head) return;
        if(node==last) {
            last = last.prev;
            last.next = null;
        }
        else {
            DLL temp = node.prev;
            temp.next = node.next;
            temp.next.prev = temp;
        }
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }

    public LRUCache(int capacity) {
        head = null;
        last = null;
        maxCapacity = capacity;
        currCapacity = 0;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int ans = map.get(key).val;
        moveToFirst(map.get(key));
        return ans;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            DLL temp = map.get(key);
            temp.val = value;
            moveToFirst(map.get(key));
            return;
        }
        if(currCapacity < maxCapacity) {
            currCapacity++;
        }
        else {
            int keyToDelete = last.key;
            map.remove(keyToDelete);
            last = last.prev;
            if(last != null) last.next = null;
            else {
                head = null;
                last = null;
            }
        }
        DLL node = new DLL(key, value);
        map.put(key, node);
        node.next = head;
        node.prev = null;
        if(head == null) {
            head = node;
            last = node;
        }
        else {
            head.prev = node;
        }
        head = node;
    }
}
