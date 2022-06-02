package arrays.misc;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        int size = list.size();
        map.put(val,size);
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int currIndex = map.get(val);
        //replace currIndex with last element
        int size = list.size();
        Collections.swap(list,currIndex,size-1);
        map.remove(val);
        list.remove(size-1);
        if(currIndex==size-1) {
            return true;
        }
        map.put(list.get(currIndex), currIndex);
        return true;
    }

    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }

    public boolean search(int val) {
        return map.containsKey(val);
    }
}
