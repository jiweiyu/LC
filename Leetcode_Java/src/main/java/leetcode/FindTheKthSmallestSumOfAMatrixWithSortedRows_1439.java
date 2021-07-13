package leetcode;

import java.awt.print.PrinterIOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindTheKthSmallestSumOfAMatrixWithSortedRows_1439 {

    public int kthSmallest_binarysearch(int[][] mat , int k){
        int m = mat.length, n = mat[0].length;
        int left = m, right = m*5000, ans = -1;
        while(left < right){
            int mid = left + (right - left)/2;
            int cnt = countArraysHaveSumLessOrEqual(mat, m, n, mid, 0, 0, k);
            if(cnt >= k){
                ans = mid;
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return ans;
    }

    int countArraysHaveSumLessOrEqual(int[][] mat, int m, int n, int targetSum, int r, int sum, int k){
        if(sum > targetSum) return 0;
        if(r == m) return 1;
        int ans = 0;
        for(int c = 0; c<n; c++){
            int cnt = countArraysHaveSumLessOrEqual(mat, m, n, targetSum, r+1, sum+mat[r][c], k-ans);
            if(cnt == 0) break;
            ans+=cnt;
            if(ans > k) break;
        }
        return ans;
    }

    //pq
    //Time: O(m * n * k * log(k))
    //Space: O(k)
    public int kthSmallest_pq(int[][] mat, int k){
        int col = Math.min(mat[0].length, k);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for(int[] row : mat){
            PriorityQueue<Integer> nextPq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i : pq){
                for(int c = 0; c< col; c++){
                    nextPq.add(i+row[c]);
                    //keep pq size <= k
                    if(nextPq.size()>k){
                        nextPq.poll();
                    }
                }
            }
            pq = nextPq;
        }
        return pq.poll();
    }

}
