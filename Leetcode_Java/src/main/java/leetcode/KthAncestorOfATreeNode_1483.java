package leetcode;

/*
https://leetcode.com/problems/kth-ancestor-of-a-tree-node/discuss/686362/JavaC%2B%2BPython-Binary-Lifting

**HARD
 */

public class KthAncestorOfATreeNode_1483 {

    int[][] jump;
    int maxPow;


    //TreeAncestor
    public KthAncestorOfATreeNode_1483(int n, int[] parent) {
        // log_base_2(n)
        maxPow = (int) (Math.log(n) / Math.log(2)) + 1;
        jump = new int[maxPow][n];
        jump[0] = parent;
        for (int p = 1; p < maxPow; p++) {
            for (int j = 0; j < n; j++) {
                int pre = jump[p - 1][j];
                jump[p][j] = pre == -1 ? -1 : jump[p - 1][pre];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int maxPow = this.maxPow;
        while (k > 0 && node > -1) {
            if (k >= 1 << maxPow) {
                node = jump[maxPow][node];
                k -= 1 << maxPow;
            } else
                maxPow -= 1;
        }
        return node;
    }
}

/*
[-1, 0, 0, 1, 1, 2, 2]

jump:

[-1,  0,   0,  1, 1, 2, 2]
[-1, -1,  -1,  0, 0, 0, 0]
[-1, -1,  -1,  -1, -1, -1, -1]
 */