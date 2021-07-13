package leetcode;
import java.util.*;
public class PeekingIterator_284 implements Iterator<Integer>  {
    Iterator<Integer> iter;
    Integer cache;

    public PeekingIterator_284(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        peek();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        // if(cache != null){
        //     return cache;
        // }
        // if(iter.hasNext()){
        //     cache = iter.next();
        //     return cache;
        // }
        // return null;
        return cache != null ? cache : iter.hasNext() ? cache = iter.next() : null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(cache != null){
            int res = cache;
            cache = null;
            return res;
        }else{
            if(iter.hasNext()){
                return iter.next();
            }else{
                return null;
            }
        }

    }

    @Override
    public boolean hasNext() {
        if(cache != null || iter.hasNext()){
            return true;
        }
        return false;
    }
}
