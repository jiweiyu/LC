package microsoft;

import java.util.*;
/*
Follow-up Questions
What if the given array is already sorted? How would you optimize your algorithm?

We can use either Approach 2 or Approach 3, dropping the sort of course. It will give us linear time and constant memory complexity.
What if nums1's size is small compared to nums2's size? Which algorithm is better?

Approach 1 is a good choice here as we use a hash map for the smaller array.
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

If nums1 fits into the memory, we can use Approach 1 to collect counts for nums1 into a hash map. Then, we can sequentially load and process nums2.

If neither of the arrays fit into the memory, we can apply some partial processing strategies:

Split the numeric range into subranges that fits into the memory. Modify Approach 1 to collect counts only within a given subrange, and call the method multiple times (for each subrange).

Use an external sort for both arrays. Modify Approach 2 to load and process arrays sequentially.
 */

public class intersectionOfTwoArraysII_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

}
