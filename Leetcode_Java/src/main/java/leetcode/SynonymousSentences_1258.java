package leetcode;
import java.util.*;
public class SynonymousSentences_1258 {

    //DFS
    Map<String, List<String>> graph = new HashMap<>();

    public List<String> generateSentences_dfs(List<List<String>> synonyms, String text) {
        List<String> ret = new ArrayList<>(), curr = new ArrayList<>();
        buildGraph(synonyms);
        String[] arr = text.split("\\s");
        helper(arr, 0, curr, ret);
        return ret;
    }

    private void buildGraph(List<List<String>> synonyms) {
        for(List<String> list : synonyms) {
            graph.putIfAbsent(list.get(0), new ArrayList<>());
            graph.putIfAbsent(list.get(1), new ArrayList<>());
            graph.get(list.get(0)).add(list.get(1));
            graph.get(list.get(1)).add(list.get(0));
        }
    }

    private String getJoinedStrings(List<String> curr) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<curr.size(); i++) {
            if(i != 0) sb.append(" ");
            sb.append(curr.get(i));
        }
        return new String(sb);
    }

    private void helper(String[] arr, int i, List<String> curr, List<String> ret) {
        if(i == arr.length) {
            ret.add(getJoinedStrings(curr));
            return;
        }
        String word = arr[i];
        if(!graph.containsKey(word)) {
            curr.add(word);
            helper(arr, i+1, curr, ret);
            curr.remove(curr.size()-1);
        } else {
            List<String> synonyms = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            dfs(word, visited, synonyms);
            Collections.sort(synonyms);
            for(String synonym : synonyms) {
                curr.add(synonym);
                helper(arr, i+1, curr, ret);
                curr.remove(curr.size()-1);
            }
        }
    }

    private void dfs(String curr, Set<String> visited, List<String> traversal) {
        if(visited.contains(curr)) return;
        visited.add(curr);
        for(String neighbor : graph.get(curr)) {
            dfs(neighbor, visited, traversal);
        }
        traversal.add(curr);
    }

    //BFS
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : synonyms) {
            String w1 = pair.get(0), w2 = pair.get(1);
            connect(graph, w1, w2);
            connect(graph, w2, w1);
        }
        // BFS
        Set<String> ans = new TreeSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(text);
        while (!q.isEmpty()) {
            String out = q.remove();
            ans.add(out); // Add to result
            String[] words = out.split("\\s");
            for (int i = 0; i < words.length; i++) {
                if (graph.get(words[i]) == null) continue;
                for (String synonym : graph.get(words[i])) { // Replace words[i] with its synonym
                    words[i] = synonym;
                    String newText = String.join(" ", words);
                    if (!ans.contains(newText)) q.add(newText);
                }
            }
        }
        return new ArrayList<>(ans);
    }
    void connect(Map<String, List<String>> graph, String v1, String v2) {
        graph.putIfAbsent(v1, new LinkedList<>());
        graph.get(v1).add(v2);
    }
}
