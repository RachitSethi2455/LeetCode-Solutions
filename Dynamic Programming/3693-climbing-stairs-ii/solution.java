class Solution {
    public int mincost(int n,int[] costs,int i,int[] dp){
        if(i == n ){
            return 0;
        }
        if(dp[i] !=0){
            return dp[i];
        }

        int c1 = Integer.MAX_VALUE;
        int c2 = Integer.MAX_VALUE;
        int c3 = Integer.MAX_VALUE;

        if(i+1 <=n){
            c1 = costs[i] + 1 + mincost(n,costs,i+1,dp);
        }
        if(i+2 <=n){
            c2 = costs[i+1] + 4 + mincost(n,costs,i+2,dp);
        }
        if(i+3 <=n){
            c3 = costs[i+2] + 9 + mincost(n,costs,i+3,dp);
        }

        return dp[i]=Math.min(c1,Math.min(c2,c3));
    }
    public int climbStairs(int n, int[] costs) {
        int[] dp= new int[n+1];
        return mincost(n,costs,0,dp);
    }
}