package leetcode;

import java.util.Arrays;

public class MaximumProductOfWordLengths_318 {
    public int maxProduct(String[] words) {
        int max = 0;

        Arrays.sort(words, (a,b)->(b.length()-a.length()));
        int[] masks = new int[words.length];

        for(int i=0;i<masks.length;i++){
            for(char c : words[i].toCharArray()){
                masks[i] |= 1<<(c-'a');
            }
        }

        for(int i=0;i<masks.length;i++){
            if(words[i].length()*words[i].length()<=max) break;
            for(int j=i+1;j<masks.length;j++){
                if((masks[i]&masks[j])==0){
                    max = Math.max(max, words[i].length()*words[j].length());
                    break;
                }
            }
        }
        return max;
    }
}
