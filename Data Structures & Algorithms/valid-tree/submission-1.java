
class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n - 1) {
            return false;
        }

        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] vis = new boolean[n];

        if(isCycle(graph, 0, -1, vis)) {
            return false;
        }

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean isCycle(
        ArrayList<Integer>[] graph,
        int cur,
        int par,
        boolean[] vis
    ) {

        vis[cur] = true;

        for(int neigh : graph[cur]) {

            if(!vis[neigh]) {
                if(isCycle(graph, neigh, cur, vis)) {
                    return true;
                }
            }
            else if(neigh != par) {
                return true;
            }
        }

        return false;
    }
}
