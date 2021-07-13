package leetcode;

import java.util.*;

public class FindAndReplacePattern_890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = F(pattern);
        List<String> res = new ArrayList<>();
        for(String w : words){
            if(Arrays.equals(F(w), p)) res.add(w);
        }
        return res;
    }

    public int[] F(String w){
        HashMap<Character,Integer> m = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];
        for(int i = 0;i<n;i++){
            m.putIfAbsent(w.charAt(i), m.size());
            res[i] = m.get(w.charAt(i));
        }
        return res;
    }

    public List<String> findAndReplacePattern_(String[] words, String pattern) {
        List<String> res= new LinkedList<>();
        for (String w: words){
            int[] p= new int[26], s= new int[26];
            boolean same=true;
            for (int i=0; i<w.length(); i++){
                if (s[w.charAt(i)-'a']!=p[pattern.charAt(i)-'a']){
                    same=false;
                    break;
                }else{
                    s[w.charAt(i)-'a']=p[pattern.charAt(i)-'a']=i+1;
                }
            }
            if (same) res.add(w);
        }
        return res;
    }
}
