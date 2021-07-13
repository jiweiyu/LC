package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//The List is used to store numbers and serve the getRandom() method.
//        The Map contains the mapping between the value and its index in the ArrayList.
//        The Map helps to check whether a value is already inserted or not.
//        The main trick is when you remove a value.
//        ArrayList's remove method is O(n) if you remove from random location.
//        To overcome that, we swap the values between (randomIndex, lastIndex)
//        and always remove the entry from the end of the list.
//        After the swap, you need to update the new index of the swapped value
//        (which was previously at the end of the list) in the map.

public class InsertDeleteGetRandomO1_380 {

    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    Random rand = new Random();

    InsertDeleteGetRandomO1_380(){
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }

    public boolean insert(int val){
        boolean contain = locs.containsKey(val);
        if(contain) return false;
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val){
        boolean contain = locs.containsKey(val);
        if(!contain) return false;
        int loc = locs.get(val);
        if(loc < nums.size()-1){ // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size()-1);
            nums.set(loc, lastone);
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }

    public int getRandom(){
        return nums.get(rand.nextInt(nums.size()));
    }

}
