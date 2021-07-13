package leetcode;
import java.util.*;
public class TheKthFactorOfN_1492 {

    //O(n)
    public int kthFactor_(int n, int k) {
        for(int i=1; i<=n; i++){
            if(n % i == 0 && --k ==0){
                return i;
            }
        }
        return -1;
    }

    //Heap, O(sqrt{N} log{k})
    // max heap -> to keep max element always on top
    Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    // push into heap
    // by limiting size of heap to k
    public void heappushK(int x, int k) {
        heap.add(x);
        if (heap.size() > k) {
            heap.remove();
        }
    }

    public int kthFactor(int n, int k) {
        int sqrtN = (int) Math.sqrt(n);
        for (int x = 1; x < sqrtN + 1; ++x) {
            if (n % x == 0) {
                heappushK(x, k);
                if (x != n / x) {
                    heappushK(n / x, k);
                }
            }
        }

        return k == heap.size() ? heap.poll() : -1;
    }
}
