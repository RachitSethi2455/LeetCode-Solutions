class Solution {
    public int maxSubArray(int[] nums) {
        /*int maxsum = nums[0];
        for(int i =0; i< nums.length ; i++){
            int sum =0;
            for(int j=i;j< nums.length; j++){
                sum = sum + nums[j];
                maxsum = Math.max(maxsum,sum);
            }
        }
        return maxsum;*/
        int maxsum= nums[0];
        int sum =0;
        for(int i =0; i < nums.length; i++){
            sum = sum + nums[i];
            maxsum =Math.max(sum,maxsum);
            if(sum<0){
                sum =0;
            }
        }
        return maxsum;
    }
}