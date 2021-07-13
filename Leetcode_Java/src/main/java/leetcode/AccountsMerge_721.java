package leetcode;

import java.util.*;

public class AccountsMerge_721 {

    //Union Find
    class UnionFind{
        int size;
        int[] parent;

        public UnionFind(int size){
            this.size = size;
            this.parent = new int[size];
            for(int i=0;i<size;i++){
                parent[i] = i;
            }
        }

        public void union(int a, int b){
            parent[find(a)] = parent[find(b)];
        }

        public int find(int x){
            if(x!=parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts.size()==0){
            return new ArrayList<>();
        }
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        Map<String, Integer> mailToIndex = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String curMail = accounts.get(i).get(j);
                if(mailToIndex.containsKey(curMail)){
                    int preIndex = mailToIndex.get(curMail);
                    uf.union(preIndex, i);
                }
                else{
                    mailToIndex.put(curMail, i);
                }
            }
        }

        Map<Integer, Set<String>> disjoinSet = new HashMap<>();
        for(int i=0;i<n;i++){
            int parentIndex = uf.find(i);
            disjoinSet.putIfAbsent(parentIndex,new HashSet<>());

            Set<String> curSet = disjoinSet.get(parentIndex);
            for(int j=1;j<accounts.get(i).size();j++){
                curSet.add(accounts.get(i).get(j));
            }
            disjoinSet.put(parentIndex, curSet);
        }

        List<List<String>> result = new ArrayList<>();
        for(int index : disjoinSet.keySet()){
            List<String> curList = new ArrayList<>();
            if(disjoinSet.containsKey(index)){
                curList.addAll(disjoinSet.get(index));
            }
            Collections.sort(curList);
            curList.add(0,accounts.get(index).get(0));
            result.add(curList);
        }
        return result;
    }

}

