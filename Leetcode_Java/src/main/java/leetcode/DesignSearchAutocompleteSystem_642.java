package leetcode;

import java.util.*;

public class DesignSearchAutocompleteSystem_642 {

    class TrieNode{
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;
        public TrieNode(){
            children = new HashMap<Character, TrieNode>();
            counts = new HashMap<String, Integer>();
            isWord = false;
        }
    }

    class Pair{
        String s;
        int c;
        public Pair(String s, int c){
            this.s = s; this.c = c;
        }
    }

    TrieNode root;
    String prefix;

    public DesignSearchAutocompleteSystem_642(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for(int i = 0; i <sentences.length; i++){
            add(sentences[i], times[i]);
        }
    }

    private void add(String s, int count){
        TrieNode curr = root;
        for(char c : s.toCharArray()){
            TrieNode next = curr.children.get(c);
            if(next == null){
                next = new TrieNode();
                curr.children.put(c,next);
            }
            curr = next;
            curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
        }
        curr.isWord = true;
    }

    public List<String> input(char c) {
        if(c == '#'){
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }

        prefix = prefix + c;
        TrieNode curr = root;
        for(char cc : prefix.toCharArray()){
            TrieNode next = curr.children.get(cc);
            if(next == null){
                return new ArrayList<>();
            }
            curr = next;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
        for(String s : curr.counts.keySet()){
            pq.add(new Pair(s, curr.counts.get(s)));
        }

        List<String> res = new ArrayList<String>();
        for(int i = 0 ; i < 3 && !pq.isEmpty(); i++){
            res.add(pq.poll().s);
        }
        return res;
    }

    // use counts map to store list of String
    //return Collections.emptyList() - immutability
//    private static class TrieNode{
//        Map<Character, TrieNode> children;
//        Map<String, Integer> counts;
//
//        public TrieNode(){
//            this.children = new HashMap<>();
//            this.counts = new HashMap<>();
//        }
//    }
//
//    private static class Pair implements Comparable<Pair>{
//        String s;
//        int c;
//
//        public Pair(String s, int c){
//            this.s = s;
//            this.c = c;
//        }
//
//        @Override
//        public int compareTo(Pair o){
//            if(this.c == o.c){
//                return this.s.compareTo(o.s);
//            }
//            return Integer.compare(o.c, this.c);
//        }
//    }
//
//    private TrieNode root;
//    private StringBuilder prefix;
//    private TrieNode inputNode;
//
//    public AutocompleteSystem(String[] sentences, int[] times) {
//        this.root = new TrieNode();
//        this.prefix = new StringBuilder();
//        this.inputNode = this.root;
//
//        for(int i = 0;i < sentences.length; i++){
//            insert(sentences[i], times[i]);
//        }
//    }
//
//    private void insert(String word, int count){
//        TrieNode cur = this.root;
//        for(int i = 0; i< word.length();i++){
//            char c = word.charAt(i);
//            cur = cur.children.computeIfAbsent(c, k->new TrieNode());
//            cur.counts.put(word, cur.counts.getOrDefault(word, 0) + count);
//        }
//    }
//
//    public List<String> input(char c) {
//        if(c == '#'){
//            this.inputNode = this.root;
//            insert(this.prefix.toString(), 1);
//            this.prefix = new StringBuilder();
//            return Collections.emptyList();
//        }
//
//        this.prefix.append(c);
//        TrieNode child = this.inputNode.children.get(c);
//        if(child == null){
//            this.inputNode.children.put(c, new TrieNode());
//            this.inputNode = this.inputNode.children.get(c);
//            return Collections.emptyList();
//        }
//        this.inputNode = child;
//
//        PriorityQueue<Pair> pq = new PriorityQueue<>();
//        for(Map.Entry<String, Integer> entry : this.inputNode.counts.entrySet()){
//            pq.add(new Pair(entry.getKey(), entry.getValue()));
//        }
//
//        List<String> res = new ArrayList<>();
//
//        for(int i = 0; i < 3 && !pq.isEmpty(); i++){
//            res.add(pq.poll().s);
//        }
//
//        return res;
//    }

}
