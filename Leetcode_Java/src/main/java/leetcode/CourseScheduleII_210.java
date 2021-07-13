package leetcode;

import java.util.*;

public class CourseScheduleII_210 {

    public int[] findOrder_from207(int n, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[n];
        int[] degree = new int[n];
        ArrayList<Integer> bfs = new ArrayList();
        for (int i = 0; i < n; ++i) G[i] = new ArrayList<Integer>();
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for (int i = 0; i < n; ++i) if (degree[i] == 0) bfs.add(i);
        for (int i = 0; i < bfs.size(); ++i)
            for (int j: G[bfs.get(i)])
                if (--degree[j] == 0) bfs.add(j);
        int[] res = bfs.stream().mapToInt(i->i).toArray();
        return res.length==n?res:new int[0];
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }

        // How many courses don't need prerequisites.
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        // If indegree is zero, then add the course to the order.
                        order[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
    }



    // offical solution: topological sort
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder;

    private void init(int numCourses){
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();

        //by default, all vertces are WHITE
        for(int i=0; i<numCourses;i++){
            this.color.put(i, WHITE);
        }
    }

    private void dfs(int node){
        if(!this.isPossible){
            return;
        }

        this.color.put(node, GRAY);

        //Traverse on neighboring vertices
        for(Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())){
            if(this.color.get(neighbor) == WHITE){
                this.dfs(neighbor);
            }else if(this.color.get(neighbor) == GRAY){
                this.isPossible = false;
            }
        }

        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);
    }

    public int[] findOrder_DFS(int numCourses, int[][] prerequisites) {
        this.init(numCourses);

        for(int i=0; i <prerequisites.length; i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);
        }

        for(int i=0; i<numCourses; i++){
            if(this.color.get(i) == WHITE){
                this.dfs(i);
            }
        }

        int[] order;
        if(this.isPossible){
            order = new int[numCourses];
            for(int i=0;i<numCourses;i++){
                order[i] = this.topologicalOrder.get(numCourses-i-1);
            }
        }else{
            order = new int[0];
        }
        return order;
    }

}
