class Solution {
    public int countComponents(int n, int[][] edges) {

        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){

            int a = edge[0];
            int b = edge[1];

            graph[a].add(b);
            graph[b].add(a);
        }
        boolean[] vis = new boolean[n];

        int cnt = 0;
        for(int i=0;i<n;i++){

            if(!vis[i]){
                dfs(graph, i, vis);
                cnt++;
            }
        }

        return cnt;
        
    }

    public void dfs(ArrayList<Integer>[] graph, int cur, boolean[] vis){

        vis[cur] = true;

        for(int neigh : graph[cur]){

            if(!vis[neigh]){
                dfs(graph, neigh, vis);
            }
        }

    }
}
