package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache_460 {

    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;  //visted count
    HashMap<Integer, LinkedHashSet<Integer>> lists;  //frequent count
    /*LinkedHashSet is also an implementation of Set interface,
    it is similar to the HashSet and TreeSet except
    the below mentioned differences:
    HashSet doesn't maintain any kind of order of its elements.
    TreeSet sorts the elements in ascending order.
    LinkedHashSet maintains the insertion order.*/
    int cap;
    int min = -1;
    public LFUCache_460(int capacity){
        cap = capacity;
        vals = new HashMap<>(); //key-value
        counts = new HashMap<>(); //key-count
        lists = new HashMap<>(); //count-list of key
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key){
        if(!vals.containsKey(key)){
            return -1;
        }
        int count = counts.get(key);
        counts.put(key,count+1);
        lists.get(count).remove(key);
        if(count==min && lists.get(count).size()==0){
            min++;
        }
        if(!lists.containsKey(count+1)){
            lists.put(count+1,new LinkedHashSet<>());
        }
        lists.get(count+1).add(key);
        return vals.get(key);
    }

    public void set(int key, int value){
        if(cap <= 0) return;
        if(vals.containsKey(key)){
            vals.put(key,value);
            get(key); //set count and frequent
            return;
        }
        if(vals.size() >= cap){
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
        }
        //new key
        vals.put(key,value);
        counts.put(key,1);
        min=1;
        lists.get(1).add(key);
    }


}
