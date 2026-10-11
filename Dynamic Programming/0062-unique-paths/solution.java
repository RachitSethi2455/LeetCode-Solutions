class Solution {
    /*int helper(int m, int n, int i, int j){
        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j >= n) return 0;
        int right = helper(m,n,i+1,j);
        int down = helper(m,n,i,j+1);
        return right + down;
    }
    public int uniquePaths(int m, int n) {
        return helper(m,n,0,0);
    }*/
    int helper(int m, int n, int i, int j, int[][] dp){
        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j >= n) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        int right = helper(m,n,i+1,j,dp);
        int down = helper(m,n,i,j+1,dp);

        return dp[i][j] = down + right;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(m,n,0,0,dp);
    }
}