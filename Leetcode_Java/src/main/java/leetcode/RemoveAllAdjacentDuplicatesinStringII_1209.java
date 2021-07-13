package leetcode;

import java.util.*;
class Pair {
    int cnt;
    char ch;
    public Pair(int cnt, char ch) {
        this.ch = ch;
        this.cnt = cnt;
    }
}

public class RemoveAllAdjacentDuplicatesinStringII_1209 {

    public String removeDuplicates_recursion(String s, int k) {
        int count = 1;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)) count++;
            else count = 1;
            if(count == k) s = removeDuplicates_recursion(s.substring(0, i - k + 2) + s.substring(i + 2), k);
        }
        return s;
    }

    public String removeDuplicates_stack(String s, int k) {
        Stack<Pair> counts = new Stack<>();
        for(int i = 0; i <s.length(); i++){
            if(counts.empty() || s.charAt(i) != counts.peek().ch){
                counts.push(new Pair(1, s.charAt(i)));
            }else{
                if(++counts.peek().cnt == k){
                    counts.pop();
                }
            }
        }
        StringBuilder b = new StringBuilder();
        while(!counts.empty()){
            Pair p = counts.pop();
            for(int i = 0; i < p.cnt; i++){
                b.append(p.ch);
            }
        }
        return b.reverse().toString();
    }

    public String removeDuplicates_pointer(String s, int k) {
        Stack<Integer> counts = new Stack<>();
        char[] sa = s.toCharArray();
        int j = 0;
        for (int i = 0; i < s.length(); ++i, ++j) {
            sa[j] = sa[i];
            if (j == 0 || sa[j] != sa[j - 1]) {
                counts.push(1);
            } else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    j = j - k;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return new String(sa, 0, j);
    }
}
