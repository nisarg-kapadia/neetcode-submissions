class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m = image.length;
        int n = image[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(i == sr && j == sc){

                    int orgColor = image[i][j];
                    fill(image, i, j, orgColor, color, vis);
                }
            }
        }

        return image;
    }

    public int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public void fill(int[][] image, int r, int c, int orgColor, int color, boolean[][] vis){

        vis[r][c] = true;
        image[r][c] = color;
        for(int[] d : directions){

            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && !vis[nr][nc] && image[nr][nc] == orgColor){

                fill(image, nr, nc, orgColor, color, vis);
            }
        }
    }
}