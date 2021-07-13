package leetcode;

public class MergeSortedArray_88 {

    //Time complexity : O(n+m).
    //Space complexity : O(1).
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind = m + n - 1; // last index of combined array
        int x = m - 1;
        int y = n - 1;
        while (x >= 0 && y >= 0) {
            if (nums1[x] > nums2[y]) {
                nums1[ind--] = nums1[x--];
            }
            else {
                nums1[ind--] = nums2[y--];
            }
        }
        while (x >= 0) { // leftovers of nums1
            nums1[ind--] = nums1[x--];
        }
        while (y >= 0) { // leftovers of nums2
            nums1[ind--] = nums2[y--];
        }

    }
}
