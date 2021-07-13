package leetcode;

public class MedianOfTwoSortedArrays_4 {

    public static int findKthSmallest(int[] a, int m, int begin1, int[] b, int n, int begin2, int k) {

        if (m > n)
            return findKthSmallest(b, n, begin2, a, m, begin1, k);
        if (m == 0)
            return b[begin2 + k - 1];
        if (k == 1)
            return Integer.min(a[begin1], b[begin2]);
        int partA = Integer.min(k / 2, m), partB = k - partA;
        if (a[begin1 + partA - 1] == b[begin2 + partB - 1])
            return a[begin1 + partA - 1];
        else if (a[begin1 + partA - 1] > b[begin2 + partB - 1])
            return findKthSmallest(a, m, begin1, b, n - partB, begin2 + partB, k - partB);
        else
            return findKthSmallest(a, m - partA, begin1 + partA, b, n, begin2, k - partA);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, sumLen = len1 + len2;
        if (sumLen % 2 != 0) {

            return findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1);
        } else {
            return (findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2)
                    + findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1)) / 2.0;
        }

    }

    //binary search
    public double findMedianSortedArrays_(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(m>n){
            return findMedianSortedArrays(nums2, nums1);
        }

        int i=0,j=0,imin=0,imax=m,half=(m+n+1)/2;
        double maxLeft = 0, minRight = 0;
        while(imin<=imax){
            i = (imin+imax)/2;
            j = half - i;
            if(j>0 && i<m && nums2[j-1] > nums1[i]){
                imin = i+1;
            }else if(i>0 && j<n && nums1[i-1] > nums2[j]){
                imax = i-1;
            }else{
                if(i==0){
                    maxLeft = nums2[j-1];
                }else if(j==0){
                    maxLeft = nums1[i-1];
                }else{
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }
                break;
            }
        }
        if((m+n) % 2 == 1){
            return maxLeft;
        }
        if(i==m){
            minRight = nums2[j];
        }else if(j==n){
            minRight = nums1[i];
        }else{
            minRight = Math.min(nums1[i],nums2[j]);
        }
        return (maxLeft+minRight) /2;
    }
}
