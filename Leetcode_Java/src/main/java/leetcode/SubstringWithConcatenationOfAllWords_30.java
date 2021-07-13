package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords_30 {

    public List<Integer> findSubstring(String s, String[] words){
        HashMap<String, Integer> counts = new HashMap<>();
        for(String word : words){
            counts.put(word,counts.getOrDefault(word,0)+1);
        }
        List<Integer> indexes = new ArrayList<>();
        int n = s.length(), num = words.length, len = words[0].length();
        for(int i=0;i<n-num*len+1;i++){
            HashMap<String, Integer> seen = new HashMap<>();
            int j=0;
            while(j<num){
                String word = s.substring(i+j*len, i+(j+1)*len);
                if(counts.containsKey(word)){
                    seen.put(word, seen.getOrDefault(word,0)+1);
                    if(seen.get(word)>counts.getOrDefault(word,0)){
                        break;
                    }
                }else{
                    break;
                }
                j++;
            }
            if(j==num){
                indexes.add(i);
            }
        }
        return indexes;
    }
}
