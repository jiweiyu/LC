package leetcode;
import java.util.*;
public class RandomPickWithBlacklist_710 {

    //whilte list
    //Time Complexity: O(N) preprocessing. O(1) pick. Preprocessing is too slow to pass the time limit.
    //Space Complexity: O(N). MLE (Memory Limit Exceeded) will occur.
    List<Integer> whitelist;
    Random r = new Random();
    int total;

    public RandomPickWithBlacklist_710(int n, int[] blacklist) {
        whitelist = new ArrayList<>();
        Set<Integer> W = new HashSet<>();
        int a = 0;
        while(a < n){
            W.add(a++);
        }
        for(int b : blacklist){
            System.out.println(b);
            W.remove(b);
        }
        for(int x : W){
            whitelist.add(x);
        }

        total = whitelist.size();
    }

    public int pick() {
        if(total <= 0) return 0;
        int ran = r.nextInt(total);
        //System.out.println(ran +"," + total);
        int res = whitelist.get(ran);
        //whitelist.remove(res);
        return res;
    }

    //remap blacklist
    //Time Complexity: O(B) preprocessing. O(1)O(1) pick.
    //Space Complexity: O(B).
//    Map<Integer, Integer> m;
//    Random r;
//    int wlen;

//    public Solution(int n, int[] b) {
//        m = new HashMap<>();
//        r = new Random();
//        wlen = n - b.length;
//        Set<Integer> w = new HashSet<>();
//        for (int i = wlen; i < n; i++) w.add(i);
//        for (int x : b) w.remove(x);
//        Iterator<Integer> wi = w.iterator();
//        for (int x : b)
//            if (x < wlen)
//                m.put(x, wi.next());
//    }

//    public int pick() {
//        int k = r.nextInt(wlen);
//        return m.getOrDefault(k, k);
//    }
}
