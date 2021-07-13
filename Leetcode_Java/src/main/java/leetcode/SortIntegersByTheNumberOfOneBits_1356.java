package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortIntegersByTheNumberOfOneBits_1356 {


    /**
     Since the input values can range from 0 to 10000, we can add to each element on the array the value of the bit count (number of 1s) multiplied by 10001.
     10001 is not a magic number, it is merely the max possible number the array may have + 1, which ensures that the bit count has the maximum priority,
     and that we do not mistakenly erase a number when reverting the array back to its original values (after sorting).
     This approach is an effective way of sorting by more than one criteria, a similar logic could be applied to more complex problems.
     */
    public int[] sortByBits_(int[] arr) {
        // apply a bitcount modifier to the array values
        for(int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        }

        // sort the array, and remove the bitcount modifier
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            arr[i] %= 10001;
        }

        // return the sorted array
        return arr;
    }

    public static int[] sortByBits(int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(Integer::bitCount).thenComparingInt(n -> n));

        for(int a : arr) {
            q.add(a);
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = q.poll();
        }
        return arr;
    }

    public void main(String[] args){
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8};
        int[] res = new int[arr.length];

        res = sortByBits(arr);
    }

}
