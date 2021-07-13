package leetcode;
import java.util.*;
public class CrackingTheSafe_753 {
    public String crackSafe(int n, int k) {
        Set<String> visited = new HashSet<String>();
        //*start from string "00.."
        String res = "";
        for(int j = 0; j < n; j++){
            res+=0;
        }
        //*calculate target length, which is k^n+n-1
        int total = 1;
        for(int i = 0; i < n; i++){
            total *= k;
        }
        total += n-1;
        //*run DFS
        res=DFS(res, n, k, visited, total);
        return res;
    }
    private String DFS(String res, int n, int k, Set<String> visited, int total){
        int len = res.length();
        visited.add(res.substring(len-n, len));
        for(int i = 0; i < k; i++){
            if(!visited.contains(res.substring(len-n+1, len)+i)){
                String tmp = DFS(res+i, n, k, visited, total);
                //*if length of result is less than total length, remove substring from visited and continue loop, else we are done! break the loop!
                if(tmp.length() == total){
                    res = tmp;
                    break;
                }
                visited.remove(res.substring(len-n+1, len)+i);
            }
        }
        return res;
    }

}
