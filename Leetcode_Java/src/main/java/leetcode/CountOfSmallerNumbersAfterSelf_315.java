package leetcode;
import java.util.*;
import java.util.stream.Collectors;

public class CountOfSmallerNumbersAfterSelf_315 {

    //jiwei's solution TLE on test case 15/16
    public List<Integer> countSmaller(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            res[i] = count(map, nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<res.length;i++){
            list.add(res[i]);
        }
        return list;
    }

    private int count(TreeMap<Integer, Integer> map, int a){
        int res = 0;
        while(map.lowerEntry(a)!=null){
            res += map.lowerEntry(a).getValue();
            a = map.lowerKey(a);
        }
        return res;
    }

    //use BST
    public List<Integer> countSmaller_BST(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        TreeNode_315 root = new TreeNode_315(nums[nums.length-1]);
        res.add(0);
        for(int i = nums.length-2;i>=0;i--){
            int count = insertNode(root,nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }

    public int insertNode(TreeNode_315 root, int val){
        int thisCount = 0;
        while(true){
            if(val<=root.val){
                root.count++;
                if(root.left==null){
                    root.left=new TreeNode_315(val);
                    break;
                }else{
                    root=root.left;
                }
            }else{
                thisCount += root.count;
                if(root.right==null){
                    root.right=new TreeNode_315(val);
                    break;
                }else{
                    root = root.right;
                }
            }
        }
        return thisCount;
    }


}

class TreeNode_315 {
    TreeNode_315 left;
    TreeNode_315 right;
    int val;
    int count = 1;
    public TreeNode_315(int val) {
        this.val = val;
    }
}