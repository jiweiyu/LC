package leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSquares_425 {

    //DFS
    class Node{
        Node[] nodes;
        String word;
        Node(){
            this.nodes = new Node[26];
            this.word = null;
        }
    }
    void add(Node root, String word){
        Node node = root;
        for (char c : word.toCharArray() ) {
            int idx = c-'a';
            if (node.nodes[idx] == null) node.nodes[idx] = new Node();
            node = node.nodes[idx];
        }
        node.word = word;
    }
    void helper(int row, int col, int len, Node[] rows, List<List<String>> ret) {
        if ( (col == row) && (row == len) ) { // last char
            List<String> res = new ArrayList<String>();
            for (int i=0; i<len; i++) {
                res.add(rows[i].word);
            }
            ret.add( res );
        } else { // from left to right and then go down to the next row
            if ( col < len  ) { // left to right first
                Node pre_row = rows[row];
                Node pre_col = rows[col];
                for (int i=0; i<26; i++) { // find all the possible next char
                    if ( (rows[row].nodes[i] != null) && (rows[col].nodes[i] != null) ) {
                        rows[row] = rows[row].nodes[i];
                        if (col != row) rows[col] = rows[col].nodes[i];
                        helper(row, col+1, len, rows, ret);
                        rows[row] = pre_row;
                        if (col != row) rows[col] = pre_col;
                    }
                }
            } else { // reach the end of column, go to the next row
                helper(row+1, row+1, len, rows, ret);
            }
        }
    }
    public List<List<String>> wordSquares_DFS(String[] words) {
        List<List<String>> ret = new ArrayList();
        if (words==null || words.length==0) return ret;
        Node root = new Node();
        int len = words[0].length();
        for (String word: words) add(root, word);
        Node[] rows = new Node[len];
        for (int i=0; i<len; i++) rows[i]=root;
        helper(0, 0, len, rows, ret);
        return ret;
    }


    //Trie BFS
    class TrieNode{
        TrieNode[] children;
        List<String> startWith;

        TrieNode(){
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }

    class Trie{
        TrieNode root;

        Trie(String[] words){
            root = new TrieNode();
            for(String w: words){
                TrieNode cur = root;
                for(char ch: w.toCharArray()){
                    int idx = ch-'a';
                    if(cur.children[idx] == null){
                        cur.children[idx] = new TrieNode();
                    }
                    cur.children[idx].startWith.add(w);
                    cur = cur.children[idx];
                }
            }
        }

        List<String> findByPrefix(String prefix){
            List<String> ans = new ArrayList<>();
            TrieNode cur = root;
            for(char ch : prefix.toCharArray()){
                int idx = ch-'a';
                if(cur.children[idx] == null) return ans;
                cur = cur.children[idx];
            }
            ans.addAll(cur.startWith);
            return ans;
        }
    }

    public List<List<String>> wordSquares(String[] words){
        List<List<String>> ans = new ArrayList<>();
        if(words==null || words.length==0) return ans;
        int len = words[0].length();
        Trie trie = new Trie(words);
        List<String> ansBuilder = new ArrayList<>();
        for(String w: words){
            ansBuilder.add(w);
            search(len, trie, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size()-1);
        }
        return ans;
    }

    private void search(int len, Trie tr, List<List<String>> ans, List<String> ansBuilder){
        if(ansBuilder.size()==len){
            ans.add(new ArrayList<>(ansBuilder));
            return;
        }

        int idx = ansBuilder.size();
        StringBuilder prefixBuilder = new StringBuilder();
        for(String s: ansBuilder){
            prefixBuilder.append(s.charAt(idx));
        }
        List<String> startWith = tr.findByPrefix(prefixBuilder.toString());
        for(String sw: startWith){
            ansBuilder.add(sw);
            search(len,tr,ans,ansBuilder);
            ansBuilder.remove(ansBuilder.size()-1);
        }
    }

}
