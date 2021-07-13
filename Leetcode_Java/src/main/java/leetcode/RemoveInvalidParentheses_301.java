package leetcode;

import java.util.*;

public class RemoveInvalidParentheses_301 {

    //dfs
    public List<String> removeInvalidParentheses_dfs(String s){
        int rmL = 0, rmR = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                rmL++;
            }else if(s.charAt(i)==')'){
                if(rmL !=0){
                    rmL--;
                }else{
                    rmR++;
                }
            }
        }
        Set<String> res = new HashSet<>();
        dfs(s,0,res,new StringBuilder(),rmL,rmR, 0);
        return new ArrayList<String>(res);
    }

    public void dfs(String s,
                    int i,
                    Set<String> res,
                    StringBuilder sb,
                    int rmL,
                    int rmR,
                    int open){
        if(rmL<0 || rmR < 0 || open < 0){
            return;
        }
        if(i==s.length()){
            if(rmL==0 && rmR == 0 && open == 0){
                res.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(i);
        int len = sb.length();

        if(c=='('){
            dfs(s,i+1,res,sb,rmL-1,rmR,open);
            dfs(s,i+1,res,sb.append(c),rmL,rmR,open+1);
        }else if(c==')'){
            dfs(s,i+1,res,sb,rmL,rmR-1, open);
            dfs(s,i+1,res,sb.append(c), rmL, rmR, open-1);
        }else{
            dfs(s,i+1,res,sb.append(c),rmL,rmR,open);
        }
        sb.setLength(len);
    }

    //bfs
    public List<String> removeInvalidParentheses_bfs(String s){
        List<String> res = new ArrayList<>();

        if(s==null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;
        while(!queue.isEmpty()){
            s = queue.poll();

            if(isValid(s)){
                res.add(s);
                found = true;
            }

            if(found) continue;

            for(int i=0;i<s.length();i++){
                if(s.charAt(i) !='(' && s.charAt(i) !=')') continue;
                String t = s.substring(0,i)+s.substring(i+1);
                if(!visited.contains(t)){
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return res;
    }

    boolean isValid(String s){
        int count = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(') count++;
            if(c == ')' && count-- ==0) return false;
        }
        return count==0;
    }
}
