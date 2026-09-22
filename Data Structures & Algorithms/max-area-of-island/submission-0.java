class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        int maxArea = 0;

        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                if(grid[i][j] == 1 && !vis[i][j]){
                    vis[i][j] = true;
                    maxArea = Math.max(maxArea, dfs(grid, i, j, vis));
                }
            }
        }

        return maxArea;
    }

    public int[][] directions = {{0, 1},{0, -1},{1,0},{-1, 0}};

    public int dfs(int[][] grid, int r, int c, boolean[][] vis){

        int area = 1;

        for(int[] d : directions){

            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1 && !vis[nr][nc]){
                vis[nr][nc] = true;
                area += dfs(grid, nr, nc, vis);
            }

        }

        return area;
    }
}
