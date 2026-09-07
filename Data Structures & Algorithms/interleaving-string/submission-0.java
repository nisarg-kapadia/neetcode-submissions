class Solution {

    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int m = s1.length();
        int n = s2.length();

        if(m + n != s3.length()){

            return false;
        }

        dp = new Boolean[m + 1][n + 1];

        return canInterleave(s1, s2, s3, 0, 0);
    }

    public boolean canInterleave(String s1, String s2, String s3, int i, int j){

        if(i == s1.length() && j == s2.length()){
            return true;
        }

        if(dp[i][j] != null){

            return dp[i][j];
        }

        int k = i + j;

        boolean picks1 = false;
        if(i < s1.length() && (s1.charAt(i) == s3.charAt(k))){
            picks1 = canInterleave(s1, s2, s3, i + 1, j);
        }

        boolean picks2 = false;

        if(j < s2.length() && (s2.charAt(j) == s3.charAt(k))){
            picks2 = canInterleave(s1, s2, s3, i, j + 1);
        }

       return dp[i][j] = picks1 || picks2;
    }
}
