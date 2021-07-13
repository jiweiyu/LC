package leetcode;
import java.util.*;

//Output Limit Exceeded
//replace hashMap with HashSet to improve
public class PseudoPalindromicPathsInABinaryTree_1457 {


    public int pseudoPalindromicPaths (TreeNode root) {
        int[] path = new int[1000];
        int level = 0;
        int res = 0;
        return travesal(root, path, level, res);
    }

    public int travesal(TreeNode node, int[] path, int level, int count){
        if(node == null) {
            return count;
        }
        path[level] = node.val;
        level++;
        if(node.left==null && node.right==null){
            if(isPseudoPalindrom(path, level)) return 1;
        }
        return travesal(node.left, path, level, count)+travesal(node.right, path, level, count);
    }

    public boolean isPseudoPalindrom(int[] path, int level){

        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("check path:");
        for(int i=0; i<level;i++){
            map.put(path[i], map.getOrDefault(path[i],0)+1);
            System.out.println(path[i]);
        }
        int check_odd = 0;
        for(int a : map.keySet()){

            System.out.println("chech map: " + a + ", " + map.get(a));

            if(map.get(a)%2 > 0){
                check_odd++;
                if(check_odd>1) return false;
            }
        }
        System.out.println("true");
        return true;
    }

    //save space
    int result = 0;
    public int pseudoPalindromicPaths_ (TreeNode root) {
        int[] map = new int[10];
        findPesudoPalindromUtil_(root,map);
        return result;
    }

    void findPesudoPalindromUtil_(TreeNode root,int[] map){

        if(root == null){
            return;
        }
        map[root.val] = map[root.val]+1;
        if(root.left == null && root.right == null){
            if(isPalindrome(map))
                result++;
        }

        findPesudoPalindromUtil_(root.left,map);
        findPesudoPalindromUtil_(root.right,map);
        //backtrack
        map[root.val] = map[root.val]-1;


    }
    boolean isPalindrome(int[] map){
        int miss = 0;
        for(int i=0;i<=9;i++){
            if(map[i] % 2 != 0)
                miss++;
            if(miss > 1)
                return false;
        }
        return true;
    }
}
