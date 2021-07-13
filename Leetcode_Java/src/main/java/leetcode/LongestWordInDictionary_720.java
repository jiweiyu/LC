package leetcode;

import java.util.*;

class Node_720{
    char c;
    HashMap<Character, Node_720> children  = new HashMap<>();
    int end;
    public Node_720(char c){
        this.c = c;
    }
}

class Trie{

    Node_720 root;
    String[] words;
    public Trie(){
        root = new Node_720('0');
    }

    public void insert(String word, int index){
        Node_720 cur = root;
        for(char c : word.toCharArray()){
            cur.children.putIfAbsent(c, new Node_720(c));
            cur = cur.children.get(c);
        }
        cur.end = index;
    }

    public String dfs(){
        String ans = "";
        Stack<Node_720> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node_720 node = stack.pop();
            if(node.end > 0 || node == root){
                if(node != root){
                    String word = words[node.end - 1];
                    if(word.length() > ans.length() ||
                        word.length() == ans.length() && word.compareTo(ans) < 0){
                        ans = word;
                    }
                }
                for(Node_720 nei : node.children.values()){
                    stack.push(nei);
                }
            }
        }
        return ans;
    }
}

public class LongestWordInDictionary_720 {

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for(String word : words){
            trie.insert(word, ++index);
        }
        trie.words = words;
        return trie.dfs();
    }
}
