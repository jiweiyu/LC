package leetcode;
import java.util.*;
public class InsertDeleteGetRandomO1DupAllowed_381 {

    ArrayList<Integer> nums;
    HashMap<Integer, Set<Integer>> locs;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1DupAllowed_381() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        locs.computeIfAbsent(val, k->new HashSet<>()).add(nums.size());

        nums.add(val);
        if(contain) return false;
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {

        boolean contain = locs.containsKey(val);
        if(!contain) return false;
        Set<Integer> loc = locs.get(val);
        int toremove = loc.iterator().next();
        int last = nums.size()-1;
        int lastone = nums.get(last);

        loc.remove(toremove);
        if(loc.size() == 0){
            locs.remove(val);
        }

        if(toremove < last){ // not the last one than swap the last one with this val

            nums.set(toremove, lastone);
            Set<Integer> lastoneInd = locs.get(lastone);
            lastoneInd.remove(last);
            lastoneInd.add(toremove);
            locs.put(lastone, lastoneInd);
        }

        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
