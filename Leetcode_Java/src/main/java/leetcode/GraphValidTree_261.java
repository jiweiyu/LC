package leetcode;

import java.util.Arrays;

public class GraphValidTree_261 {

    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;
        if (m != n - 1) return false; //a valid tree with n node, should have n - 1 edges and no cycles..

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            int root1 = findRoot(e[0], parent);
            int root2 = findRoot(e[1], parent);
            if (root1 == root2) { //find cycle..
                return false;
            }
            parent[root1] = root2;
        }
        return true;
    }

    //find root with path compression...
    private int findRoot(int i, int[] parent) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
