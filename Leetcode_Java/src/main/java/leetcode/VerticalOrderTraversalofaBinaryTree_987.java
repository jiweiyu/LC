package leetcode;

import java.io.PipedReader;
import java.util.*;
public class VerticalOrderTraversalofaBinaryTree_987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: ys.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    private void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map){
        if(root == null) return;
        if(!map.containsKey(x)){
            map.put(x, new TreeMap<>());
        }
        if(!map.get(x).containsKey(y)){
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).offer(root.val);
        dfs(root.left, x-1, y+1, map);
        dfs(root.right, x+1, y+1, map);
    }
}
/*
    HashMap 是线程不安全的哈希表，如果需要同步用Collections.synchronizedMap(map); 键不能重复，值可以，可以存储null键值，取数据无顺序之分

        LinkedHashMap：是一个维持双向链表，是一个有序的Map，怎么put的进去的输出时怎么取出，FIFO的顺序


        TreeMap： 在需要排序的时候使用，在一个map放入很多数据，需要按照什么规则排序显示的时候。

        Map<String, String> map = new TreeMap<String, String>(new Comparator<Object>(){    

                public int compare(Object o1, Object o2) {           

                          String  key1 = o1.toString();   

                          Stirng  key2 = o2.toString();   

                          return key1.compareTo(key2);  

                  }});    
*/
