package leetcode;

import java.util.LinkedList;

public class RemoveAllAdjacentDuplicatesInString_1047 {

    public String removeDuplicates_1(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }

    public String removeDuplicates_2(String S) {
        LinkedList<Character> list = new LinkedList<>();
        for(int i=0;i<S.length();i++){
            Character c = S.charAt(i);
            if(!list.isEmpty() && list.peekLast() == c){
                while(!list.isEmpty() && list.peekLast() == c){
                    list.removeLast();
                }
                continue;
            }
            list.addLast(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!list.isEmpty()){
            sb.append(list.pollFirst());
        }
        return sb.toString();
    }
}
