class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                if(grid[i][j] == 0){

                    q.offer(new int[]{i, j, 0});

                    while(!q.isEmpty()){

                        int[] cur = q.poll();

                        int r = cur[0];
                        int c = cur[1];
                        int dist = cur[2];
                        int newDist = dist + 1;
                        for(int[] d : directions){
                            
                            int nr = r + d[0];
                            int nc = c + d[1];

                            if(nr >= 0 && nc >=0 && nr < m && nc < n && grid[nr][nc] > 0){
                                
                                
                                if(grid[nr][nc] == Integer.MAX_VALUE){
                                    grid[nr][nc] = newDist;
                                    q.offer(new int[]{nr, nc, newDist});
                                }else if(newDist < grid[nr][nc]){
                                    grid[nr][nc] = newDist;
                                    q.offer(new int[]{nr, nc, newDist});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
