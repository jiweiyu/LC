package leetcode;

import java.util.*;

public class WordLadderII_126 {


    //bfs + dfs
    public List<List<String>> findLadders_(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<String>(wordList);
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
        HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
        ArrayList<String> solution = new ArrayList<String>();

        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict)
            nodeNeighbors.put(str, new ArrayList<String>());

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {// Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))// Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd)
                break;
        }
    }

    // Find all next level nodes.
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char[] chs = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }




    //bfs + backtrack
    Map<String, List<String>> map;
    List<List> results;
    public List<List> findLadders (String start, String end, Set<String> dict){
        results = new ArrayList<>();
        if(dict.size()==0) return results;

        int min = Integer.MAX_VALUE;
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        map = new HashMap<String, List<String>>();

        Map<String, Integer> ladder = new HashMap<>();
        for(String s : dict){
            ladder.put(s, Integer.MAX_VALUE);
        }
        ladder.put(start, 0);
        dict.add(end);

        while(!queue.isEmpty()){
            String word = queue.poll();
            int step = ladder.get(word)+1;
            if(step>min) break;
            for(int i=0;i<word.length();i++){
                StringBuilder sb = new StringBuilder(word);
                for(char ch = 'a';ch<='z';ch++){
                    sb.setCharAt(i, ch);
                    String new_word = sb.toString();
                    if(ladder.containsKey(new_word)){
                        if(step>ladder.get(new_word)){
                            continue;
                        }else if(step<ladder.get(new_word)){
                            queue.add(new_word);
                            ladder.put(new_word, step);
                        }else;

                        if(map.containsKey(new_word)){
                            map.get(new_word).add(word);
                        }else{
                            List<String> list = new LinkedList<String>();
                            list.add(word);
                            map.put(new_word,list);
                        }
                        if(new_word.equals(end)) {
                            min = step;
                        }
                    }
                }
            }
        }
        LinkedList<String> result = new LinkedList<>();
        backTrace(end,start,result);
        return results;
    }

    private void backTrace(String word, String start, List<String> list){
        if(word.equals(start)){
            list.add(0,start);
            results.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(0,word);
        if(map.get(word)!=null){
            for(String s : map.get(word)){
                backTrace(s,start,list);
            }
        }
        list.remove(0);
    }

}
