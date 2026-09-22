class Solution {

    public int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid, i, j, vis);
                    count++;
                }
            }
        }

        return count;


    }

    public void dfs(char[][] grid, int r, int c, boolean[][] vis){

        vis[r][c] = true;

        for(int[] d : directions){

            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && !vis[nr][nc] && grid[nr][nc] == '1'){

                dfs(grid, nr, nc, vis);
            }
        }
    }
}
