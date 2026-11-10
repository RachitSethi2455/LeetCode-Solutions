class Solution {
    public int minstep(int n,int i,int[] dp){
        if (i == n) return 1;
        if (i > n) return 0;
        if(dp[i] != -1){
            return dp[i];
        }

        return dp[i]=minstep(n,i+1,dp) + minstep(n,i+2,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minstep(n,0,dp);
    }
}