class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int len  = 2 * n;
        int[] ans = new int[len];
        for(int i=0;i<len;i++){
            if(i<n){
                ans[i] = nums[i];
            }
            if(i>=n){
                ans[i] = nums[i-n];
            }
        }
        return ans;
    }
}