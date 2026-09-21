class Solution {

    public int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int islandPerimeter(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;

        int perimeter = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(grid[i][j] == 1){
                    perimeter += cnt(grid, i, j);
                }
            }
        }

        return perimeter;
    }

    public int cnt(int[][] grid, int r, int c){

        int row = grid.length;
        int col = grid[0].length;
        int p = 4;
        for(int[] d : directions){

            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < row && nc >=0 && nc < col && grid[nr][nc] == 1){
                p--;
            }
        }

        return p;
    }

    
}