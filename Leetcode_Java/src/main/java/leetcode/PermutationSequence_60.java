package leetcode;
import java.util.*;
public class PermutationSequence_60 {

    //O(N^2)
    public String getPermutation(int n, int k) {
        char[] result = new char[n];
        int[] a = decode(--k, n-1);
        List<Character> l = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            l.add((char) (i+48));
        }
        for(int i = 0; i < a.length; i++){
            int index = a[i];
            result[i] = l.remove(index);
        }
        result[n-1] = l.remove(0);
        return new String(result);
    }

    private int[] decode(int n, int len){
        int[] result = new int[len];
        int base = 2;
        for(int i = len - 1; i >= 0; i--){
            result[i] = n % base;
            n /= base;
            base++;
        }
        return result;
    }
}
