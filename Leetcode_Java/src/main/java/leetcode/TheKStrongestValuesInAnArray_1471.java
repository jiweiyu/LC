package leetcode;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TheKStrongestValuesInAnArray_1471 {

    public static int[] getStrongest(int[] arr, int k){
        Arrays.sort(arr);
        int med = arr[(arr.length-1)/2];
        int[] kStrongest = new int[k];
        /*arr = Arrays.stream(arr)
                .boxed()
                .sorted((a, b) ->{
                    int x = Math.abs(a - med);
                    int y = Math.abs(b - med);
                    if(x != y) return x-y;
                    return a-b;
                        })
                .mapToInt(i->i)
                .toArray();*/
        ArrayList<Integer> ns = new ArrayList<>();
        for(int f: arr) ns.add(f);
        ns.sort((i1, i2) -> {
            int diff = Math.abs(i2 - med) - Math.abs(i1 - med);
            if(diff == 0){
                return i2 - i1;
            }
            return diff;
        });
        for(int i = 0; i<k; i++){
            kStrongest[i] = ns.get(i);
        }
        return kStrongest;
    }
}
