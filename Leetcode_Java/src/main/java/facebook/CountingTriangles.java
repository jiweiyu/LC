package facebook;
import java.util.*;
public class CountingTriangles {

    class Sides{
        int a;
        int b;
        int c;
        Sides(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    // Add any helper functions you may need here


    int countDistinctTriangles(ArrayList<Sides> arr) {
        // Write your code here
        HashSet<String> set = new HashSet<>();
        for(Sides t : arr){
            PriorityQueue<Integer> p = new PriorityQueue<>();
            p.add(t.a);
            p.add(t.b);
            p.add(t.c);
            int a = p.poll();
            int b = p.poll();
            int c = p.poll();
            set.add(a + "-" + b + "-" + c);
        }
        return set.size();
    }
}
