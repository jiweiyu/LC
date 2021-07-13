package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindLatestGroupOfSizeM_1562 {

    public int findLatestStep(int[] arr, int m) {
        int res = -1, n = arr.length;
        Map<Integer, Integer> cl = new HashMap<>(), fl = new HashMap<>();  // length of ceiling and floor to glue
        int[] ls = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int pos = arr[i], ceil = cl.getOrDefault(pos + 1, 0), floor = fl.getOrDefault(pos - 1, 0), newLen = ceil + floor + 1;
            if (ceil > 0) ls[ceil]--;
            if (floor > 0) ls[floor]--;
            cl.put(pos - floor, newLen);  // new range;
            fl.put(pos + ceil, newLen);
            ls[newLen]++;  // new range length;
            if (ls[m] > 0) res = i + 1;  // last
        }
        return res;
    }
}
