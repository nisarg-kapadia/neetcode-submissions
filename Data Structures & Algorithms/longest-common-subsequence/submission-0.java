class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }

        return lcs(text1, text2, 0, 0, dp);
    }

    public int lcs(String s1, String s2, int i, int j, int[][] dp){

        if(i >= s1.length() || j >= s2.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int take = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            take = 1 + lcs(s1, s2, i + 1, j + 1, dp);
        }
        int notTake = Math.max(lcs(s1, s2, i + 1, j, dp), lcs(s1, s2, i, j+1, dp));

        return dp[i][j] = Math.max(take, notTake);
    }
}
