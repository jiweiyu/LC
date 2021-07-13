package microsoft;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/*
itemsPerBucket is set to 1001 to deal with the edge case when the key is 0 even though the description specify the number value ranges from 1-100k.
This will occupy 1000 additional booleans in memory.
 */
public class DesignHashSet_705 {
    //Class name should MyHashSet

    private final int buckets = 1000;
    private final int itemsPerBucket = 1001;
    private final boolean[][] table;

    public DesignHashSet_705(){
        table = new boolean[buckets][];
    }

    public int hash(int key){
        return key % buckets;
    }

    public int pos(int key){
        return key / buckets;
    }

    public void add(int key){
        int hashkey = hash(key);

        if(table[hashkey] == null){
            table[hashkey] = new boolean[itemsPerBucket];
        }
        table[hashkey][pos(key)] = true;
    }

    public void remove(int key){
        int hashkey = hash(key);

        if(table[hashkey] != null){
            table[hashkey][pos(key)] = false;
        }
    }

    public boolean contains(int key){
        int hashkey = hash(key);
        return table[hashkey] != null && table[hashkey][pos(key)];
    }



}

/////////solution with extend size ////////////
class MyHashSet{
    List<Integer>[] container = null;
    int cap = 1000;
    double loadFactor = 0.75;
    int count = 0;
    /** Initialize your data structure here. */
    public MyHashSet() {
        container = new LinkedList[cap];
    }

    public void add(int key){
        if(contains(key)) return;
        if(loadFactor*cap == count){
            count = 0;
            //rehash
            cap *= 2;
            List<Integer>[] oldC = container;
            container = new LinkedList[cap];
            for(int i=0; i < oldC.length; i++){
                List<Integer> list = oldC[i];
                if(list != null){
                    for(int entry : list)
                        this.add(entry);
                }
            }
        }
        int hash = key % cap;
        if(container[hash] == null)
            container[hash] = new LinkedList<>();
        container[hash].add(key);
        ++count;
    }

    public void remove(int key){
        int hash = key % cap;
        List<Integer> list = container[hash];
        if(list != null){
            Iterator<Integer> itr = list.iterator();
            while(itr.hasNext())
                if(itr.next() == key){
                    itr.remove();
                    --count;
                }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key % cap;
        List<Integer> list = container[hash];
        if(list != null){
            Iterator<Integer> itr = list.iterator();
            while(itr.hasNext())
                if(itr.next() == key)
                    return true;
        }
        return false;
    }
}