package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraverseII_1424 {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = 0, i = 0, maxKey = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int r = nums.size() - 1; r >= 0; --r) { // The values from the bottom rows are the starting values of the diagonals.
            for (int c = 0; c < nums.get(r).size(); ++c) {
                map.putIfAbsent(r + c, new ArrayList<>());
                map.get(r + c).add(nums.get(r).get(c));
                maxKey = Math.max(maxKey, r + c);
                n++;
            }
        }
        int[] ans = new int[n];
        for (int key = 0; key <= maxKey; ++key) {
            List<Integer> value = map.get(key);
            if (value == null) continue;
            for (int v : value) ans[i++] = v;
        }
        return ans;
    }
}
